package com.nisum.reactivescorecard.di;

import android.content.Context;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.ScoreDB;
import com.nisum.reactivescorecard.persistance.dao.IPlayer;
import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;
import com.nisum.reactivescorecard.viewmodels.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class ViewModelFactoryModule {

    @Provides
    public IPlayer playerDao(Context context){
        return ScoreDB.getInstance(context).playerDao();
    }

    @Provides
    public IPlayerDataSource providePlayerDataSource(IPlayer playerDao){
        return new PlayerDataSource(playerDao);
    }

    @Provides
    public ViewModelFactory provideViewModelFactory(IPlayerDataSource providePlayerDataSource){
        return new ViewModelFactory(providePlayerDataSource);
    }
}
