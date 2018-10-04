package com.nisum.reactivescorecard.di;

import android.content.Context;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.ScoreDB;
import com.nisum.reactivescorecard.persistance.dao.IPlayer;
import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;

import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.class)
public class ViewModelFactoryModule {

    @Provides
    public IPlayer playerDao(Context context){
        return ScoreDB.getInstance(context).playerDao();
    }

    @Provides
    public IPlayerDataSource providePlayerDataSource(IPlayer playerDao){
        return new PlayerDataSource(playerDao);
    }
}
