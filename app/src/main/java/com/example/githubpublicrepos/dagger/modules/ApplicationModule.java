package com.example.githubpublicrepos.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.githubpublicrepos.Constants;
import com.example.githubpublicrepos.utils.BaseUrlInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Dagger Module with application(singleton) scoped dependencies.
 */


@Module()
public class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL);

    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor(Constants.BASE_URL);
    }

}