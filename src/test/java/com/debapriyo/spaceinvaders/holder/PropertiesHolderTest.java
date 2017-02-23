package com.debapriyo.spaceinvaders.holder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link PropertiesHolder}.
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class PropertiesHolderTest {

    /**
     * Tests all the accessors
     * 
     * @throws Exception
     */
    @Test
    public void testAccessors() throws Exception {
        assertEquals("Getter for radar image file name property", "radarImage.txt", PropertiesHolder.INSTANCE.getRadarImageFileName());
        assertEquals("Getter for known space invaders file name property", "knownSpaceInvaders.txt", PropertiesHolder.INSTANCE.getKnownSpaceInvadersImageFileName());
        assertEquals("Getter for radar image noise tolerance percentage property", 0, PropertiesHolder.INSTANCE.getRadarImageNoiseTolerancePercentage());
    }
}