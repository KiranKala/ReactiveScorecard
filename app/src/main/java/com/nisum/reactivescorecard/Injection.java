package com.nisum.reactivescorecard;

import android.content.Context;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.ScoreDB;
import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;
import com.nisum.reactivescorecard.viewmodels.ViewModelFactory;

public class Injection {

    public static IPlayerDataSource providePlayerDataSource(Context context){
        ScoreDB scoreDB = ScoreDB.getInstance(context);
        return new PlayerDataSource(scoreDB.playerDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context){
        IPlayerDataSource playerDataSource = providePlayerDataSource(context);
        return new ViewModelFactory(playerDataSource);
    }
}
