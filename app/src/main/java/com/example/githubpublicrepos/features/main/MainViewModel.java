package com.example.githubpublicrepos.features.main;

import android.arch.lifecycle.ViewModel;

import com.example.githubpublicrepos.data.api.GithubService;
import com.example.githubpublicrepos.data.entities.User;
import com.example.githubpublicrepos.features.main.adapter.RepoViewModel;
import com.example.githubpublicrepos.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Flowable;

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

    Flowable<User> getUser(String login) {
        return service.getUser(login);
    }

    Flowable<RepoViewModel> getRepositories() {
        return service.listRepos("jakeWharton")
                .flatMap(Flowable::fromIterable)
                .flatMap(repo -> getUser(repo.getOwner().getLogin())
                        .map(user -> new RepoViewModel(repo.getName(), repo.getRepoFullname(), user.getName())))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

}
