package com.nisum.reactivescorecard;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.ScoreDB;
import com.nisum.reactivescorecard.persistance.dto.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PlayerDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private ScoreDB mDatabase;

    Player player = new Player("Playername", 100);

    @Before
    public void initDb() throws Exception {
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                ScoreDB.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void getPlayersWhenNoPlayersInserted() {
        mDatabase.playerDao().getPlayers()
                .test()
                .assertNoValues();
    }

    @Test
    public void shouldInsertPlayer(){
        mDatabase.playerDao().insertPlayer(player);
        mDatabase.playerDao().insertPlayer(new Player("Player 2", 200));

        mDatabase.playerDao().getPlayers()
                .test()
                .assertValue(players -> {

                    return players != null && players.size() == 2;
                });
    }

    @Test
    public void shouldUpdateScore(){
        mDatabase.playerDao().insertPlayer(player);

        player.setScore((player.getScore()+1));
        player.setId(1);
        mDatabase.playerDao().updateScore(player);

        mDatabase.playerDao().getPlayers()
                .test()
                .assertValue(players -> {
                    return (players != null && players.size() == 1 && players.get(0).getScore() == 101);
                });
    }

    @Test
    public void shouldDeletePlayer(){
        mDatabase.playerDao().insertPlayer(player);
        mDatabase.playerDao().insertPlayer(new Player("Player 2", 200));

        mDatabase.playerDao().getPlayers()
                .test()
                .assertValue(players -> {

                    return players != null && players.size() == 2;
                });

        mDatabase.playerDao().deletePlayer(1);
        mDatabase.playerDao().getPlayers()
                .test()
                .assertValue(players -> {
                    return players != null && players.size() == 1;
                });
    }
}
