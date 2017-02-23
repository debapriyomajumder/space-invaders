package com.debapriyo.spaceinvaders.holder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debapriyo.spaceinvaders.domain.RadarImage;

/**
 * The holder for the {@link RadarImage}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum RadarImageHolder {
    INSTANCE;
    public static final String IMAGE_BOUNDARY_INDICATOR = "~";
    private final Logger LOG = LoggerFactory.getLogger(RadarImageHolder.class);
    private RadarImage radarImage;

    /**
     * Constructor, loads the {@link RadarImage}
     */
    RadarImageHolder() {
        radarImage = new RadarImage();
        String fileName = Optional.ofNullable(getClass().getClassLoader().getResource(PropertiesHolder.INSTANCE.getRadarImageFileName())) //
                        .map(URL::getFile) //
                        .orElse(null);
        try {
            Files.lines(new File(fileName).toPath()) //
                            .filter(line -> !line.contains(IMAGE_BOUNDARY_INDICATOR)) //
                            .collect(Collectors.toList()) //
                            .forEach((scanLine) -> radarImage.addScanLineToImageMatrix(scanLine));
        }
        catch (IOException e) {
            LOG.error("Failed to load radar image file {}, error message is: {}", PropertiesHolder.INSTANCE.getRadarImageFileName(), e.getMessage());
        }
        LOG.debug("Loaded entire radar image file.");
    }

    /**
     * @return the {@link RadarImage}
     */
    public RadarImage getRadarImage() {
        return radarImage;
    }
}
