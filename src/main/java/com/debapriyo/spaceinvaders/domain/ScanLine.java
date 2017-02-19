package com.debapriyo.spaceinvaders.domain;

import org.apache.commons.lang3.StringUtils;

import com.debapriyo.spaceinvaders.holder.PropertiesHolder;

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
     * 2. Will replace this {@link SpaceInvader} pattern in this line being processed by "X".<br/>
     * 
     * @param spaceInvader the {@link SpaceInvader}
     */
    public void checkForSpaceInvader(final SpaceInvader spaceInvader) {
        if (StringUtils.isNotBlank(scanLineStringBuilder.toString())) {
            for (int i = 0; i < scanLineStringBuilder.toString().length(); i++) {
                while (scanLineStringBuilder.substring(i).startsWith(spaceInvader.getInvaderPattern())) {
                    spaceInvader.detected();
                    // Replace the detected space invader with X so that it is not matched again
                    scanLineStringBuilder.replace(i, i + spaceInvader.getInvaderPattern().length(), spaceInvader.getInvaderPattern().replaceAll(".", "X"));
                    i += spaceInvader.getInvaderPattern().length();
                }
            }
        }
    }

    /**
     * Flushes unnecessary part of the line being currently scanned, <br/>
     * however leaving "n" characters at the end where "n" is the length of the biggest known {@link SpaceInvader}.<br/>
     * This is to enable handling of "edge cases".
     */
    public void flush() {
        int toBeDeletedTilIndex = scanLineStringBuilder.length() - PropertiesHolder.INSTANCE.getLenghtOfBiggestKnownSpaceInvader();
        if (toBeDeletedTilIndex > 0) {
            scanLineStringBuilder.delete(0, toBeDeletedTilIndex);
        }
    }
}
