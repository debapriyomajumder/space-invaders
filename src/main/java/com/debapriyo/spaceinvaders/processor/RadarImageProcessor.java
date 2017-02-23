package com.debapriyo.spaceinvaders.processor;

import com.debapriyo.spaceinvaders.domain.Coordinate;
import com.debapriyo.spaceinvaders.domain.Match;
import com.debapriyo.spaceinvaders.domain.SpaceInvader;
import com.debapriyo.spaceinvaders.holder.KnownSpaceInvadersHolder;
import com.debapriyo.spaceinvaders.holder.PropertiesHolder;
import com.debapriyo.spaceinvaders.holder.RadarImageHolder;

/**
 * The radar image processor.
 *
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum RadarImageProcessor {
    INSTANCE;

    /**
     * Processes the radar image.
     */
    public void process() {
        KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().forEach(this::scanRadarImageForSpaceInvader);
        KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().forEach(SpaceInvader::log);
    }

    /**
     * Scans the {@link com.debapriyo.spaceinvaders.domain.RadarImage} for this {@link SpaceInvader}
     * 
     * @param spaceInvader the {@link SpaceInvader} to detect
     */
    private void scanRadarImageForSpaceInvader(final SpaceInvader spaceInvader) {
        for (int y = 0; y < RadarImageHolder.INSTANCE.getRadarImage().getImageHeight(); y++) {
            for (int x = 0; x < RadarImageHolder.INSTANCE.getRadarImage().getImageWidth(); x++) {
                checkForSpaceInvader(spaceInvader, new Coordinate(x, y));
            }
        }

    }

    /**
     * Checks for this {@link SpaceInvader} at the {@link Coordinate} in the {@link com.debapriyo.spaceinvaders.domain.RadarImage}
     * 
     * @param spaceInvader the {@link SpaceInvader}
     * @param coordinate the {@link Coordinate}
     */
    private void checkForSpaceInvader(final SpaceInvader spaceInvader, final Coordinate coordinate) {
        int numberOfPixelsMatched = 0;
        for (int y = 0; y < spaceInvader.getImageHeight(); y++) {
            for (int x = 0; x < spaceInvader.getImageWidth(); x++) {
                String pixelInSpaceInvaderImage = spaceInvader.getPixelAt(new Coordinate(x, y));
                String pixelInRadarImage = RadarImageHolder.INSTANCE.getRadarImage().getPixelAt(new Coordinate(coordinate.getX() + x, coordinate.getY() + y));
                if (pixelInSpaceInvaderImage.equals(pixelInRadarImage)) {
                    numberOfPixelsMatched++;
                }
            }
        }
        int percentageMatched = getPercentageMatched(spaceInvader, numberOfPixelsMatched);
        if (hasAMinimumThresholdMatch(percentageMatched)) {
            spaceInvader.addMatch(new Match(percentageMatched, coordinate));
        }
    }

    /**
     * Checks whether percentage matched is below the noise tolerance level
     * 
     * @param percentageMatched the precentage matched
     * @return boolean
     */
    private boolean hasAMinimumThresholdMatch(final int percentageMatched) {
        return percentageMatched >= (100 - PropertiesHolder.INSTANCE.getRadarImageNoiseTolerancePercentage());
    }

    /**
     * Gets the percentage match for this {@link SpaceInvader}
     * 
     * @param spaceInvader the {@link SpaceInvader}
     * @param numberOfPixelsMatched the number of pixels matched
     * @return the percentage of match
     */
    private int getPercentageMatched(final SpaceInvader spaceInvader, final int numberOfPixelsMatched) {
        return (numberOfPixelsMatched * 100) / (spaceInvader.getImageWidth() * spaceInvader.getImageHeight());
    }
}
