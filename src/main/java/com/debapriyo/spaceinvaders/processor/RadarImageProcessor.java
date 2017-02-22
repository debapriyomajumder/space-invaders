package com.debapriyo.spaceinvaders.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debapriyo.spaceinvaders.domain.Coordinate;
import com.debapriyo.spaceinvaders.domain.Match;
import com.debapriyo.spaceinvaders.domain.SpaceInvader;
import com.debapriyo.spaceinvaders.holder.KnownSpaceInvadersHolder;
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
    private Logger LOG = LoggerFactory.getLogger(RadarImageProcessor.class);

    /**
     * Processes the radar image.
     */
    public void process() {
        KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().forEach(this::scanRadarImageForSpaceInvader);
        KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().forEach(SpaceInvader::log);
    }

    private void scanRadarImageForSpaceInvader(final SpaceInvader spaceInvader) {
        for (int y = 0; y < RadarImageHolder.INSTANCE.getRadarImageHeight(); y++) {
            for (int x = 0; x < RadarImageHolder.INSTANCE.getRadarImageWidth(); x++) {
                checkForSpaceInvader(spaceInvader, new Coordinate(x, y));
            }
        }

    }

    private void checkForSpaceInvader(SpaceInvader spaceInvader, Coordinate coordinate) {
        int numberOfPixelsMatched = 0;
        for (int y = 0; y < spaceInvader.getSpaceInvaderImageHeight(); y++) {
            for (int x = 0; x < spaceInvader.getSpaceInvaderImageWidth(); x++) {
                String pixelInSpaceInvaderImage = spaceInvader.getPixelAt(new Coordinate(x, y));
                String pixelInRadarImage = RadarImageHolder.INSTANCE.getPixelAt(new Coordinate(coordinate.getX() + x, coordinate.getY() + y));
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

    private boolean hasAMinimumThresholdMatch(int percentageMatched) {
        return percentageMatched >= 80;
    }

    private int getPercentageMatched(SpaceInvader spaceInvader, int numberOfPixelsMatched) {
        return (numberOfPixelsMatched * 100) / (spaceInvader.getSpaceInvaderImageWidth() * spaceInvader.getSpaceInvaderImageHeight());
    }
}
