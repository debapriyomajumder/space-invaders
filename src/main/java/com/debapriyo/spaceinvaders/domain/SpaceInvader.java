package com.debapriyo.spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private List<String> spaceInvaderMatrix;
    private List<Match> matches;

    public SpaceInvader() {
        this.spaceInvaderMatrix = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addScanLineToSpaceInvaderMatrix(String matrixLine) {
        this.spaceInvaderMatrix.add(matrixLine);
    }

    public void addMatch(Match match) {
        this.matches.add(match);
    }

    public boolean isDetected() {
        return this.matches.size() > 0;
    }

    public int getSpaceInvaderImageHeight() {
        return this.spaceInvaderMatrix.size();
    }

    public int getSpaceInvaderImageWidth() {
        return Optional.ofNullable(this.spaceInvaderMatrix.get(0)) //
                .map(String::length) //
                .orElse(0);
    }

    public String getPixelAt(Coordinate coordinate) {
        String pixelToReturn = "Y";
        if (coordinate.getY() < getSpaceInvaderImageHeight() && coordinate.getX() < getSpaceInvaderImageWidth()) {
            // requested coordinates in within the image raster
            pixelToReturn = String.valueOf(this.spaceInvaderMatrix.get(coordinate.getY()).charAt(coordinate.getX()));
        }
        return pixelToReturn;
    }
    public void log() {
        LOG.info(toString());
    }

    @Override
    public String toString() {
        String invaderPattern = "";
        for (String line : spaceInvaderMatrix) {
            invaderPattern += line + "\n";
        }
        return "The following space invader has " + (isDetected() ? "" : "not ") + "been detected" + (isDetected() ? " at " + this.matches + "" : "") + ":\n" + invaderPattern + "\n\n";
    }
}
