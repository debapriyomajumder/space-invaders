package com.debapriyo.spaceinvaders.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debapriyo.spaceinvaders.domain.ScanLine;
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
    private Logger LOG = LoggerFactory.getLogger(RadarImageProcessor.class);

    /**
     * Processes the radar image.
     */
    public void process() {
        // Initiate the scan line domain
        final ScanLine scanLineBeingProcessed = new ScanLine();
        try {
            // Process
            RadarImageHolder.INSTANCE.getRadarImageScanLinesStream().forEach(scanLine -> {
                scanLineBeingProcessed.append(scanLine);
                KnownSpaceInvadersHolder.INSTANCE //
                                .getKnownSpaceInvaders() //
                                .forEach(spaceInvader -> scanLineBeingProcessed.checkForSpaceInvader(spaceInvader));
                scanLineBeingProcessed.flush();
            });
            // Log the results
            KnownSpaceInvadersHolder.INSTANCE //
                            .getKnownSpaceInvaders() //
                            .forEach(SpaceInvader::log);
        }
        catch (Exception e) {
            LOG.error("Processing of radar image file {} failed. Error: {}", PropertiesHolder.INSTANCE.getRadarImageFileName(), e.getMessage());
        }
    }
}
