package com.nisum.reactivescorecard.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;
import com.nisum.reactivescorecard.persistance.dto.Player;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class PlayerViewModel extends ViewModel{

    private final IPlayerDataSource mPlayerDataSource;

    public PlayerViewModel(IPlayerDataSource playerDataSource){
        this.mPlayerDataSource = playerDataSource;
    }

    public Flowable<List<Player>> getPlayers(){
        return mPlayerDataSource.getPlayers();
    }

    public Completable insertPlayer(final Player player){
        return Completable.fromAction( () -> mPlayerDataSource.insertPlayer(player) );
    }

    public Completable updateScore(Player player){
        return Completable.fromAction(() -> mPlayerDataSource.updateScore(player));
    }

    public Completable deletePlayer(int playerId){
        return Completable.fromAction( () -> mPlayerDataSource.deletePlayer(playerId));
    }
}
