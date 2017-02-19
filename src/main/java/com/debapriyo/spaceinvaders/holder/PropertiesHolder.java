package com.debapriyo.spaceinvaders.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
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
    private static final String PROPERTIES_FILE_VALUE_LIST_SEPARATOR = ",";
    // Keys
    private static final String KNOWN_SPACE_INVADERS_LIST_PROPERTY_KEY = "application.space.invaders.known.list";
    private static final String RADAR_IMAGE_FILE_NAME_PROPERTY_KEY = "application.space.invaders.radar.image.file";
    // Defaults
    private static final String KNOWN_SPACE_INVADERS_LIST_PROPERTY_DEFAULT = "--o-----o--";
    private static final String RADAR_IMAGE_FILE_NAME_PROPERTY_DEFAULT = "radarImage.txt";

    private Integer largestKnownSpaceInvaderLength = null;

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

    /**
     * @return the {@link List} of {@link String}, each representing a known space invader as mentioned in the properties file.
     */
    public List<String> getKnownSpaceInvadersList() {
        return Arrays.asList(StringUtils.split(this.properties.getProperty(KNOWN_SPACE_INVADERS_LIST_PROPERTY_KEY, KNOWN_SPACE_INVADERS_LIST_PROPERTY_DEFAULT), PROPERTIES_FILE_VALUE_LIST_SEPARATOR));
    }

    /**
     * @return the name of the radar image file as mentioned in the properties file.
     */
    public String getRadarImageFileName() {
        return this.properties.getProperty(RADAR_IMAGE_FILE_NAME_PROPERTY_KEY, RADAR_IMAGE_FILE_NAME_PROPERTY_DEFAULT);
    }

    /**
     * @return the length of the largest known space invader
     */
    public int getLenghtOfBiggestKnownSpaceInvader() {
        if (null == largestKnownSpaceInvaderLength) {
            // Calculate first time
            largestKnownSpaceInvaderLength = Collections.max(getKnownSpaceInvadersList(), Comparator.comparing(s -> s.length())).length();
        }
        return this.largestKnownSpaceInvaderLength;
    }
}
