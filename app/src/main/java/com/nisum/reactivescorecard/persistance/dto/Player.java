package com.nisum.reactivescorecard.persistance.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

@Entity(tableName = "players")
public class Player {

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "score")
    private int score;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public static DiffUtil.ItemCallback<Player> DIFF_CALLBACK = new DiffUtil.ItemCallback<Player>() {
        @Override
        public boolean areItemsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public Object getChangePayload(@NonNull Player oldItem, @NonNull Player newItem) {
            return super.getChangePayload(oldItem, newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        Player player = (Player) obj;
        return player.id == this.id && player.name == this.name && player.score == this.score;
    }
}
