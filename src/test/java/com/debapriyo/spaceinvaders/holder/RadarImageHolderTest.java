package com.debapriyo.spaceinvaders.holder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.debapriyo.spaceinvaders.domain.RadarImage;

/**
 * Unit test for {@link RadarImageHolder}.
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class RadarImageHolderTest {

    /**
     * Tests the enum, whether it is able to read the file properly.
     * 
     * @throws Exception
     */
    @Test
    public void getRadarImage() throws Exception {
        RadarImage radarImage = RadarImageHolder.INSTANCE.getRadarImage();
        assertEquals("Radar image width", 18, radarImage.getImageWidth());
        assertEquals("Radar image height", 12, radarImage.getImageHeight());
    }

}