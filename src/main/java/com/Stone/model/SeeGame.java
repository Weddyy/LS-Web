package com.Stone.model;

/**
 * Created by Wed on 05.02.16.
 */
public class SeeGame {
    long chunkId,availableSince,nextAvailableChunk,keyFrameId,nextChunkId,endStartupChunkId,startGameChunkId,endGameChunkId,duration;

    public long getChunkId() {
        return chunkId;
    }

    public void setChunkId(long chunkId) {
        this.chunkId = chunkId;
    }

    public long getAvailableSince() {
        return availableSince;
    }

    public void setAvailableSince(long availableSince) {
        this.availableSince = availableSince;
    }

    public long getNextAvailableChunk() {
        return nextAvailableChunk;
    }

    public void setNextAvailableChunk(long nextAvailableChunk) {
        this.nextAvailableChunk = nextAvailableChunk;
    }

    public long getKeyFrameId() {
        return keyFrameId;
    }

    public void setKeyFrameId(long keyFrameId) {
        this.keyFrameId = keyFrameId;
    }

    public long getNextChunkId() {
        return nextChunkId;
    }

    public void setNextChunkId(long nextChunkId) {
        this.nextChunkId = nextChunkId;
    }

    public long getEndStartupChunkId() {
        return endStartupChunkId;
    }

    public void setEndStartupChunkId(long endStartupChunkId) {
        this.endStartupChunkId = endStartupChunkId;
    }

    public long getStartGameChunkId() {
        return startGameChunkId;
    }

    public void setStartGameChunkId(long startGameChunkId) {
        this.startGameChunkId = startGameChunkId;
    }

    public long getEndGameChunkId() {
        return endGameChunkId;
    }

    public void setEndGameChunkId(long endGameChunkId) {
        this.endGameChunkId = endGameChunkId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
