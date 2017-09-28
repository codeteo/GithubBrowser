package com.example.githubpublicrepos.features.main.dagger.modules;

import com.example.githubpublicrepos.dagger.ActivityScope;
import com.example.githubpublicrepos.data.api.GithubService;
import com.example.githubpublicrepos.features.main.MainViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module to provide {@link GithubService} to {@link MainViewModel}
 */

@Module
public class MainActivityServiceModule {

    @ActivityScope
    @Provides
    GithubService providesGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

}