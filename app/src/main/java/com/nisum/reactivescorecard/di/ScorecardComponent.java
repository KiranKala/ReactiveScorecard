package com.nisum.reactivescorecard.di;

import com.nisum.reactivescorecard.viewmodels.ViewModelFactory;

import dagger.Component;

@Component(modules = ViewModelFactoryModule.class)
public interface ScorecardComponent {

    ViewModelFactory getViewModelFactory();
}
