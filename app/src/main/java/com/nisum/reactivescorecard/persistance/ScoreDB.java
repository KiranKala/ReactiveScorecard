package com.nisum.reactivescorecard.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.nisum.reactivescorecard.persistance.dao.IPlayer;
import com.nisum.reactivescorecard.persistance.dto.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class ScoreDB extends RoomDatabase{

    private static ScoreDB scoreDB;
    private static final String DB_NAME = "Scroreboard.db";

    public abstract IPlayer playerDao();

    public static ScoreDB getInstance(Context context) {

        if(scoreDB == null){
            scoreDB = Room.databaseBuilder(context.getApplicationContext(), ScoreDB.class, DB_NAME)
                    .build();
        }

        return scoreDB;
    }
}
