package com.nisum.reactivescorecard.di;

import android.app.Application;

import com.nisum.reactivescorecard.ReactiveScorecardApp;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Component(modules = {
        AndroidInjectionModule.class,
        ViewModelModule.class,
        ActivityBuilder.class,
        ViewModelFactoryModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(ReactiveScorecardApp app);
}
