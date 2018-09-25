package com.nisum.reactivescorecard.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.nisum.reactivescorecard.persistance.dto.Player;

import java.util.List;

import io.reactivex.Flowable;


public interface IPlayerDataSource {

    void insertPlayer(Player player);

    Flowable<List<Player>> getPlayers();

    void updateScore(Player player);

    void deletePlayer(int playerId);
}
