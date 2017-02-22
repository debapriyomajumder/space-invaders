package com.debapriyo.spaceinvaders.holder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debapriyo.spaceinvaders.domain.Coordinate;

/**
 * The holder for the radar image file.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum RadarImageHolder {
    INSTANCE;
    private final List<String> RADAR_IMAGE_RASTER_SCAN = new ArrayList<>();
    private final Logger LOG = LoggerFactory.getLogger(RadarImageHolder.class);

    RadarImageHolder() {
        String fileName = Optional.ofNullable(getClass().getClassLoader().getResource(PropertiesHolder.INSTANCE.getRadarImageFileName())) //
                        .map(URL::getFile) //
                        .orElse(null);
        File file = new File(fileName);
        try {
            RADAR_IMAGE_RASTER_SCAN.addAll(Files.lines(file.toPath()).collect(Collectors.toList()));
        }
        catch (IOException e) {
            LOG.error("Failed to load radar image file {}, error message is: {}", PropertiesHolder.INSTANCE.getRadarImageFileName(), e.getMessage());
        }
        LOG.debug("Loaded entire radar image file.");
    }

    public int getRadarImageHeight() {
        return RADAR_IMAGE_RASTER_SCAN.size();
    }

    public int getRadarImageWidth() {
        return Optional.ofNullable(RADAR_IMAGE_RASTER_SCAN.get(0)) //
                        .map(String::length) //
                        .orElse(0);
    }

    public String getPixelAt(Coordinate coordinate) {
        String scanLineToReturn = "X";
        if (coordinate.getY() < getRadarImageHeight() && coordinate.getX() < getRadarImageWidth()) {
            // requested coordinates in within the image raster
            scanLineToReturn = String.valueOf(RADAR_IMAGE_RASTER_SCAN.get(coordinate.getY()).charAt(coordinate.getX()));
        }
        return scanLineToReturn;
    }
}
