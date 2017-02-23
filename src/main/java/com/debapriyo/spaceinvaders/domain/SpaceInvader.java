package com.debapriyo.spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Domain representing a particular space invader object.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public class SpaceInvader extends AbstractImage {

    private Logger LOG = LoggerFactory.getLogger(SpaceInvader.class);
    private static final String INVALID = "Y";
    private List<Match> matches;

    /**
     * Constructor
     */
    public SpaceInvader() {
        super();
        this.matches = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInvalidPixel() {
        return INVALID;
    }

    /**
     * Adds a {@link Match} for this {@link SpaceInvader} to the {@link List} of {@link Match}es for this <br/>
     * {@link SpaceInvader} in the image radar.
     * 
     * @param match the {@link Match}
     */
    public void addMatch(final Match match) {
        this.matches.add(match);
    }

    /**
     * Checks whether there are any {@link Match}es for this {@link SpaceInvader} in the {@link RadarImage}.
     * 
     * @return whether detected or not
     */
    public boolean isDetected() {
        return this.matches.size() > 0;
    }

    /**
     * Log this {@link SpaceInvader}
     */
    public void log() {
        LOG.info(toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String invaderPattern = "";
        for (String line : imageMatrix) {
            invaderPattern += line + "\n";
        }
        return "The following space invader has " + (isDetected() ? "" : "not ") + "been detected" + (isDetected() ? " at " + this.matches + "" : "") + ":\n" + invaderPattern + "\n\n";
    }
}
