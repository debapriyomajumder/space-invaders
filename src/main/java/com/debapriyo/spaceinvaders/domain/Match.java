package com.debapriyo.spaceinvaders.domain;

/**
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/22/2017
 */
public class Match {
    private int percentageMatched;
    private Coordinate matchedAt;

    public Match(int percentageMatched, Coordinate matchedAt) {
        this.percentageMatched = percentageMatched;
        this.matchedAt = matchedAt;
    }

    public int getPercentageMatched() {
        return percentageMatched;
    }

    public void setPercentageMatched(int percentageMatched) {
        this.percentageMatched = percentageMatched;
    }

    public Coordinate getMatchedAt() {
        return matchedAt;
    }

    public void setMatchedAt(Coordinate matchedAt) {
        this.matchedAt = matchedAt;
    }

    @Override
    public String toString() {
        return String.format("with %d percentage match at %s", percentageMatched, matchedAt);
    }
}
