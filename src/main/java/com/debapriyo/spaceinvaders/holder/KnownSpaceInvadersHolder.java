package com.debapriyo.spaceinvaders.holder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private final List<SpaceInvader> KNOWN_SPACE_INVADERS = new ArrayList<>();
    private final Logger LOG = LoggerFactory.getLogger(KnownSpaceInvadersHolder.class);

    /**
     * Private constructor, loads the list of known {@link SpaceInvader}s
     */
    KnownSpaceInvadersHolder() {
        KNOWN_SPACE_INVADERS.addAll(PropertiesHolder.INSTANCE //
                        .getKnownSpaceInvadersList() //
                        .stream() //
                        .map(SpaceInvader::new) //
                        .collect(Collectors.toList()));
        LOG.debug("Loaded all known space invaders.");
    }

    /**
     * @return the {@link List} of known {@link SpaceInvader}s
     */
    public List<SpaceInvader> getKnownSpaceInvaders() {
        return this.KNOWN_SPACE_INVADERS;
    }
}
