package com.nisum.reactivescorecard.di;

import com.nisum.reactivescorecard.views.ScorecardActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract ScorecardActivity bindMainActivity();
}
