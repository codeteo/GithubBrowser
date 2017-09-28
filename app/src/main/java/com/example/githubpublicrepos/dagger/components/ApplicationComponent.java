package com.example.githubpublicrepos.dagger.components;

import com.example.githubpublicrepos.MyApplication;
import com.example.githubpublicrepos.dagger.builder.ActivityBuilderModule;
import com.example.githubpublicrepos.dagger.modules.ApplicationModule;
import com.example.githubpublicrepos.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Dagger Component builds all dependencies with application scope.
 */

@Singleton
@Component( modules = {
        AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class,
        NetworkModule.class,})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();
    }

}

