package com.example.githubpublicrepos.features.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.githubpublicrepos.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_main_name) TextView tvName;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private MainViewModel viewModel;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(MainViewModel.class);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // subscribe to the emissions of the user from the view model.
        disposable.add(viewModel.getUser()
                .subscribe(
                        user -> tvName.setText(user.getName()),
                        throwable -> Timber.i("Error", throwable)
                ));

        disposable.add(viewModel.getRepositories()
                .subscribe(
                        repos -> Timber.i("got Repos"),
                        throwable -> Timber.i("onError", throwable)
                ));

    }

    @Override
    protected void onStop() {
        super.onStop();

        // clear all subscriptions
        disposable.clear();
    }
}
