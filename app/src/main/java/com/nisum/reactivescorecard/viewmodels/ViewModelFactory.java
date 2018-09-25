package com.nisum.reactivescorecard.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final IPlayerDataSource mPlayerDataSource;

    public ViewModelFactory(IPlayerDataSource mPlayerDataSource){
        this.mPlayerDataSource = mPlayerDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(PlayerViewModel.class)){
            return (T) new PlayerViewModel(mPlayerDataSource);
        }
        throw new IllegalArgumentException("Invalid ViewModel class");
    }
}
