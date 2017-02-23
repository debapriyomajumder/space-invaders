package com.debapriyo.spaceinvaders.domain;

/**
 * Domain representing a match of a {@link SpaceInvader} in the {@link RadarImage}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/22/2017
 */
public class Match {
    private int percentageMatched;
    private Coordinate matchedAt;

    /**
     * Constructor
     * 
     * @param percentageMatched percentage matched
     * @param matchedAt matched at location {@link Coordinate} in the {@link RadarImage}
     */
    public Match(final int percentageMatched, final Coordinate matchedAt) {
        this.percentageMatched = percentageMatched;
        this.matchedAt = matchedAt;
    }

    /**
     * @return the percentage matched
     */
    public int getPercentageMatched() {
        return percentageMatched;
    }

    /**
     * @param percentageMatched the percentage matched to set
     */
    public void setPercentageMatched(final int percentageMatched) {
        this.percentageMatched = percentageMatched;
    }

    /**
     * @return the matched at location {@link Coordinate} in the {@link RadarImage}
     */
    public Coordinate getMatchedAt() {
        return matchedAt;
    }

    /**
     * @param matchedAt the matched at location {@link Coordinate} in the {@link RadarImage} to set
     */
    public void setMatchedAt(final Coordinate matchedAt) {
        this.matchedAt = matchedAt;
    }

    /**
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("with %d percentage match at %s", percentageMatched, matchedAt);
    }
}
