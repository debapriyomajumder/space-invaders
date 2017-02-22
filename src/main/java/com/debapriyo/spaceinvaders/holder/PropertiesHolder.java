package com.debapriyo.spaceinvaders.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The holder for the application {@link Properties}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum PropertiesHolder {
    INSTANCE;
    // Properties file name
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    // Keys
    private static final String KNOWN_SPACE_INVADERS_IMAGE_FILE_NAME_PROPERTY_KEY = "application.space.invaders.known.image.file";
    private static final String RADAR_IMAGE_FILE_NAME_PROPERTY_KEY = "application.space.invaders.radar.image.file";
    private static final String RADAR_IMAGE_NOISE_LEVEL_PROPERTY_KEY = "application.space.invaders.radar.image.noise.level";
    // Defaults
    private static final String KNOWN_SPACE_INVADERS_IMAGE_FILE_NAME_PROPERTY_DEFAULT = "knownSpaceInvaders.txt";
    private static final String RADAR_IMAGE_FILE_NAME_PROPERTY_DEFAULT = "radarImage.txt";
    private static final String RADAR_IMAGE_NOISE_LEVEL_PROPERTY_DEFAULT = "1";

    private final Logger LOG = LoggerFactory.getLogger(PropertiesHolder.class);

    private Properties properties;

    /**
     * Private constructor, loads properties file
     */
    PropertiesHolder() {
        this.properties = new Properties();
        InputStream propertiesFileInputStream = null;
        try {
            String fileName = Optional.ofNullable(getClass().getClassLoader().getResource(PROPERTIES_FILE_NAME)).map(URL::getFile).orElse(null);
            propertiesFileInputStream = new FileInputStream(fileName);
            this.properties.load(propertiesFileInputStream);
            LOG.debug("Loaded data from {}", PROPERTIES_FILE_NAME);
        }
        catch (IOException e) {
            LOG.error("Failed to load properties file {}, error message is: {}", PROPERTIES_FILE_NAME, e.getMessage());
        }
        finally {
            if (null != propertiesFileInputStream) {
                try {
                    propertiesFileInputStream.close();
                }
                catch (IOException e) {
                    LOG.error("Failed to close properties file {}, error message is: {}", PROPERTIES_FILE_NAME, e.getMessage());
                }
            }
        }
    }

    public String getKnownSpaceInvadersImageFileName() {
        return this.properties.getProperty(KNOWN_SPACE_INVADERS_IMAGE_FILE_NAME_PROPERTY_KEY, KNOWN_SPACE_INVADERS_IMAGE_FILE_NAME_PROPERTY_DEFAULT);
    }

    public String getRadarImageFileName() {
        return this.properties.getProperty(RADAR_IMAGE_FILE_NAME_PROPERTY_KEY, RADAR_IMAGE_FILE_NAME_PROPERTY_DEFAULT);
    }

    public int getRadarImageNoiseLevel() {
        String noiseLevel = this.properties.getProperty(RADAR_IMAGE_NOISE_LEVEL_PROPERTY_KEY, RADAR_IMAGE_NOISE_LEVEL_PROPERTY_DEFAULT);
        return NumberUtils.isNumber(noiseLevel) ? Integer.parseInt(noiseLevel) : Integer.parseInt(RADAR_IMAGE_NOISE_LEVEL_PROPERTY_DEFAULT);
    }

}
