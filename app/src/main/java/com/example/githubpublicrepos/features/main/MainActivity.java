package com.example.githubpublicrepos.features.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.githubpublicrepos.R;
import com.example.githubpublicrepos.features.main.adapter.RepoViewModel;
import com.example.githubpublicrepos.features.main.adapter.ReposAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

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

        setAdapter();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // subscribe to the emissions of the user from the view model.
        disposable.add(viewModel.getUser("jakeWharton")
                .subscribe(
                        user -> {
                            Timber.i("onSuccess: ", user.getName());
                            tvLoadingText.setVisibility(View.GONE);
                        },
                        throwable -> Timber.i("Error", throwable)
                ));

        disposable.add(viewModel.getRepositories()
                .subscribe(
                        repoViewModel -> {
                            Timber.i("got Repos");
                            setDataToAdapter(repoViewModel);
                        },
                        throwable -> Timber.i("onError", throwable.getMessage())
                ));

    }

    private void setDataToAdapter(RepoViewModel repoViewModel) {
        adapter.addData(repoViewModel);
    }

    private void setAdapter() {
        adapter = new ReposAdapter();
        rvRepoList.setAdapter(adapter);
        rvRepoList.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
    }

    @Override
    protected void onStop() {
        super.onStop();

        // clear all subscriptions
        disposable.clear();
    }
}
