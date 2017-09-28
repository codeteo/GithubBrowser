package com.example.githubpublicrepos.features.main.dagger.components;

import com.example.githubpublicrepos.dagger.ActivityScope;
import com.example.githubpublicrepos.features.main.MainActivity;
import com.example.githubpublicrepos.features.main.dagger.modules.MainActivityModule;
import com.example.githubpublicrepos.features.main.dagger.modules.MainActivityServiceModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Dagger SubComponent for {@link MainActivity}
 */

@ActivityScope
@Subcomponent(modules = {MainActivityModule.class, MainActivityServiceModule.class})
public interface MainActivitySubComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

}