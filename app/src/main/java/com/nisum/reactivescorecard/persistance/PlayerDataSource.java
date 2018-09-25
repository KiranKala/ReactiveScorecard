package com.nisum.reactivescorecard.persistance;

import com.nisum.reactivescorecard.persistance.dao.IPlayer;
import com.nisum.reactivescorecard.persistance.dao.IPlayerDataSource;
import com.nisum.reactivescorecard.persistance.dto.Player;

import java.util.List;

import io.reactivex.Flowable;

public class PlayerDataSource implements IPlayerDataSource {

    private final IPlayer playerDao;


    public PlayerDataSource(IPlayer playerDao){
        this.playerDao = playerDao;
    }

    @Override
    public void insertPlayer(Player player) {
        playerDao.insertPlayer(player);
    }

    @Override
    public Flowable<List<Player>> getPlayers() {
        return playerDao.getPlayers();
    }

    @Override
    public void updateScore(Player player) {
        playerDao.updateScore(player);
    }

    @Override
    public void deletePlayer(int playerId) {
        playerDao.deletePlayer(playerId);
    }
}
