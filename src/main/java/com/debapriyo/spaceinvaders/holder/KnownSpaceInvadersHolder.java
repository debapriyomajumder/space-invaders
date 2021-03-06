package com.debapriyo.spaceinvaders.holder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debapriyo.spaceinvaders.domain.SpaceInvader;

/**
 * The holder for the {@link List} of known {@link SpaceInvader}s.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum KnownSpaceInvadersHolder {

    INSTANCE;

    public static final String PATTERN_SEPARATOR = "~";
    private final Logger LOG = LoggerFactory.getLogger(KnownSpaceInvadersHolder.class);
    private List<SpaceInvader> knownSpaceInvaders;

    /**
     * Private constructor, loads the list of known {@link SpaceInvader}s from file
     */
    KnownSpaceInvadersHolder() {
        knownSpaceInvaders = new ArrayList<>();
        String fileName = Optional.ofNullable(getClass().getClassLoader().getResource(PropertiesHolder.INSTANCE.getKnownSpaceInvadersImageFileName())) //
                        .map(URL::getFile) //
                        .orElse(null);
        File file = new File(fileName);
        SpaceInvader spaceInvader = new SpaceInvader();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                if (spaceInvader.getImageHeight() != 0 && StringUtils.isNotBlank(line) && line.contains(PATTERN_SEPARATOR)) {
                    knownSpaceInvaders.add(spaceInvader);
                    spaceInvader = new SpaceInvader();
                }
                else if (StringUtils.isNotBlank(line) && !line.contains(PATTERN_SEPARATOR)) {
                    spaceInvader.addScanLineToImageMatrix(line);
                }
            }

        }
        catch (IOException e) {
            LOG.error("Failed to load known space invaders image file {}, error message is: {}", PropertiesHolder.INSTANCE.getKnownSpaceInvadersImageFileName(), e.getMessage());
        }
        LOG.debug("Loaded all known space invaders.");
    }

    /**
     * @return the {@link List} of known {@link SpaceInvader}s
     */
    public List<SpaceInvader> getKnownSpaceInvaders() {
        return this.knownSpaceInvaders;
    }
}
