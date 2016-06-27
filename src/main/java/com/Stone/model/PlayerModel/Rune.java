package com.Stone.model.PlayerModel;

/**
 * Created by Wed on 04.02.16.
 */
public class Rune{
    int count;
    int runeId;

    public Rune(int count, int runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public int getRuneId() {
        return runeId;
    }
}