package com.nisum.reactivescorecard.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;
import com.nisum.reactivescorecard.persistance.dto.Player;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PlayerViewModel extends ViewModel{

    private final IPlayerDataSource mPlayerDataSource;
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    MutableLiveData<List<Player>> playersList = new MutableLiveData<>();

    @Inject
    public PlayerViewModel(IPlayerDataSource playerDataSource){
        this.mPlayerDataSource = playerDataSource;
    }

    public Flowable<List<Player>> getPlayers(){
        return mPlayerDataSource.getPlayers();
    }

    public Completable insertPlayer(final Player player){
        return Completable.fromAction( () -> mPlayerDataSource.insertPlayer(player) );
    }

    public Completable updateScore(final Player player){
        return Completable.fromAction(() -> mPlayerDataSource.updateScore(player));
    }

    public Completable deletePlayer(final int playerId){
        return Completable.fromAction( () -> mPlayerDataSource.deletePlayer(playerId));
    }

    @Override
    protected void onCleared() {
        mDisposable.clear();
    }

    public void subscribePlayersList(){
        mDisposable.add(getPlayers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(playersList -> {
                    List<Player> list = new ArrayList<>();
                    list.addAll(playersList);
                    this.playersList.setValue(list);
                }, throwable -> Log.e("Get Players", "Unable to retrieve players", throwable)));
    }

    public void insertPlayerWith(String playerName){
        mDisposable.add(insertPlayer(new Player(playerName, 0))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }, throwable -> Log.e("Insert Player", "Unable to insert Player", throwable))
        );
    }

    public MutableLiveData<List<Player>> playersResponse(){
        return playersList;
    }

    public void deletePlayerWith(int playerId){
        mDisposable.add(deletePlayer(playerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.e("Delete Player", "Player deletion completed")));
    }

    public void updateScoreWith(Player player, boolean isAdd){
        player.setScore(isAdd ? (player.getScore()+1) : (player.getScore()-1));

        mDisposable.add(updateScore(player)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.e("Update Player", "Player updation completed")));
    }
}
