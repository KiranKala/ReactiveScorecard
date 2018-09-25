package com.nisum.reactivescorecard.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.nisum.reactivescorecard.persistance.dto.Player;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface IPlayer {

    @Insert
    void insertPlayer(Player player);

    @Query("SELECT * FROM players ORDER BY score DESC")
    Flowable<List<Player>> getPlayers();

    @Update
    void updateScore(Player... players);

    @Query("DELETE FROM players where id = :playerId")
    void deletePlayer(int playerId);
}
