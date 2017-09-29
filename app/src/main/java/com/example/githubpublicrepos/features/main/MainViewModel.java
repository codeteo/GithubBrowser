package com.example.githubpublicrepos.features.main;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.githubpublicrepos.data.api.GithubService;
import com.example.githubpublicrepos.data.entities.Repo;
import com.example.githubpublicrepos.data.entities.User;
import com.example.githubpublicrepos.data.mappers.RepoMapper;
import com.example.githubpublicrepos.features.main.adapter.RepoViewModel;
import com.example.githubpublicrepos.utils.schedulers.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * View model for {@link MainActivity}
 */

public class MainViewModel extends ViewModel {

    private GithubService service;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public MainViewModel(GithubService service, BaseSchedulerProvider schedulerProvider) {
        this.service = service;
        this.schedulerProvider = schedulerProvider;
    }

    Flowable<User> getUser() {
        return service.getUser("jakeWharton")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    Flowable<List<RepoViewModel>> getRepositories() {
        return service.listRepos("jakeWharton")
                .map(mapReposToViewModel())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @NonNull
    private Function<List<Repo>, List<RepoViewModel>> mapReposToViewModel() {
        return repos -> {

            List<RepoViewModel> repoViewModelList = new ArrayList<>();

            for (Repo repo: repos ){
                RepoViewModel viewModel = RepoMapper.from(repo);
                repoViewModelList.add(viewModel);
            }

            return repoViewModelList;
        };
    }

}
