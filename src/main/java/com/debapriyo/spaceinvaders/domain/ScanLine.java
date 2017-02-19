package com.debapriyo.spaceinvaders.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Domain representing a line that is being processed at any given moment.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public class ScanLine {

    private StringBuilder scanLineStringBuilder;

    /**
     * No argument constructor
     */
    public ScanLine() {
        this.scanLineStringBuilder = new StringBuilder();
    }

    /**
     * Appends more characters to the line that is being processed.
     * 
     * @param characters string of characters to be appended
     */
    public void append(final String characters) {
        this.scanLineStringBuilder.append(characters);
    }

    /**
     * Checks for the occurrence of a given {@link SpaceInvader} pattern in the line being processed. <br/>
     * This will continue the detection as long as this {@link SpaceInvader} pattern is found at the start of the string being processed, <br/>
     * and if detected, then :<br/>
     * 1. Will notify the {@link SpaceInvader} that it has been detected.<br/>
     * 2. Will strip this {@link SpaceInvader} pattern from this line being processed.<br/>
     * 
     * @param spaceInvader the {@link SpaceInvader}
     */
    public void checkForSpaceInvader(final SpaceInvader spaceInvader) {
        while (StringUtils.isNotBlank(scanLineStringBuilder.toString())) {
            while (scanLineStringBuilder.toString().startsWith(spaceInvader.getInvaderPattern())) {
                spaceInvader.detected(); // Update space invader
                scanLineStringBuilder.delete(0, spaceInvader.getInvaderPattern().length()); // Shift n pixels
            }
            scanLineStringBuilder.delete(0, 1); // Shift one pixel
        }
    }
}
