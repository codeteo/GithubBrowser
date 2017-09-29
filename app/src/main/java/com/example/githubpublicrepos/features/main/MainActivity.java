package com.example.githubpublicrepos.features.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.githubpublicrepos.R;
import com.example.githubpublicrepos.data.entities.Repo;
import com.example.githubpublicrepos.features.main.adapter.ReposAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_main_loading) TextView tvLoadingText;
    @BindView(R.id.rv_list_repos) RecyclerView rvRepoList;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private MainViewModel viewModel;

    private CompositeDisposable disposable = new CompositeDisposable();

    private ReposAdapter adapter;

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
                        user -> {
                            Timber.i("onSuccess: ", user.getName());
                            tvLoadingText.setVisibility(View.GONE);
                        },
                        throwable -> Timber.i("Error", throwable)
                ));

        disposable.add(viewModel.getRepositories()
                .subscribe(
                        repos -> {
                            Timber.i("got Repos");
                            setAdapter(repos);
                        },
                        throwable -> Timber.i("onError", throwable.getMessage())
                ));

    }

    private void setAdapter(List<Repo> repos) {
        adapter = new ReposAdapter(repos);
        rvRepoList.setAdapter(adapter);
        rvRepoList.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // clear all subscriptions
        disposable.clear();
    }
}
