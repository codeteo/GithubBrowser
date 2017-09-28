package com.example.githubpublicrepos.features.main.dagger.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.example.githubpublicrepos.dagger.ActivityScope;
import com.example.githubpublicrepos.data.api.GithubService;
import com.example.githubpublicrepos.features.main.MainActivity;
import com.example.githubpublicrepos.features.main.MainViewModel;
import com.example.githubpublicrepos.utils.ViewModelProviderFactory;
import com.example.githubpublicrepos.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module providing dependencies for {@link MainActivity}'s ViewModel.
 */

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    MainViewModel providesMainViewModel(GithubService service, BaseSchedulerProvider schedulerProvider) {
        return new MainViewModel(service, schedulerProvider);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesMainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}