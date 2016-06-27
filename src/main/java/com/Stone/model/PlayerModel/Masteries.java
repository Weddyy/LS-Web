package com.Stone.model.PlayerModel;

/**
 * Created by Wed on 04.02.16.
 */
public class Masteries{
    int rank,masteryId;

    public Masteries(int rank, int masteryId) {
        this.rank = rank;
        this.masteryId = masteryId;
    }

    public int getRank() {
        return rank;
    }

    public int getMasteryId() {
        return masteryId;
    }
}