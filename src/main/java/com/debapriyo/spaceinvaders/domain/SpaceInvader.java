package com.debapriyo.spaceinvaders.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Domain representing a particular space invader object
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public class SpaceInvader {

    private Logger LOG = LoggerFactory.getLogger(SpaceInvader.class);
    private String invaderPattern;
    private int numberOfTimesDetected;

    /**
     * Constructor
     * 
     * @param invaderPattern the space invader pattern
     */
    public SpaceInvader(final String invaderPattern) {
        this.invaderPattern = invaderPattern;
        this.numberOfTimesDetected = 0;
    }

    /**
     * @return the space invader pattern
     */
    public String getInvaderPattern() {
        return invaderPattern;
    }

    /**
     * Increments the occurrence count of this {@link SpaceInvader} by one.
     */
    public void detected() {
        this.numberOfTimesDetected++;
    }

    /**
     * Logs the detection status of this {@link SpaceInvader}
     */
    public void log() {
        LOG.info(toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Space Invader of type \"%s\" detected %d times", this.invaderPattern, this.numberOfTimesDetected);
    }
}
