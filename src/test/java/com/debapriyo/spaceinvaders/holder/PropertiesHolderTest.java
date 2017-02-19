package com.debapriyo.spaceinvaders.holder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link PropertiesHolder}
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/19/2017
 */
public class PropertiesHolderTest {

    /**
     * Tests the getter for the known space invaders list property
     * 
     * @throws Exception
     */
    @Test
    public void getKnownSpaceInvadersList() throws Exception {
        assertEquals("Size of the list of known space invaders", 16, PropertiesHolder.INSTANCE.getKnownSpaceInvadersList().size());
        assertEquals("First element in the list of known space invaders", "--o-----o--", PropertiesHolder.INSTANCE.getKnownSpaceInvadersList().get(0));
        assertEquals("Last element in the list of known space invaders", "o-o--o-o", PropertiesHolder.INSTANCE.getKnownSpaceInvadersList().get(15));

    }

    /**
     * Tests the getter for the radar image file name property
     * 
     * @throws Exception
     */
    @Test
    public void getRadarImageFileName() throws Exception {
        assertEquals("Radar Image file name", "radarImage.txt", PropertiesHolder.INSTANCE.getRadarImageFileName());
    }

}