package com.debapriyo.spaceinvaders.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link RadarImage}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/23/2017
 */
public class RadarImageTest {

    private RadarImage unitUnderTest;

    /**
     * Sets up this test
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        unitUnderTest = new RadarImage();
    }

    /**
     * Tests the accessors
     * 
     * @throws Exception
     */
    @Test
    public void testAccessors() throws Exception {
        assertEquals("Getter for image height", 0, unitUnderTest.getImageHeight());
        assertEquals("Getter for image width", 0, unitUnderTest.getImageWidth());
        unitUnderTest.addScanLineToImageMatrix("ABC");
        assertEquals("Getter for invalid pixel", "X", unitUnderTest.getInvalidPixel());
        assertEquals("Getter for image height", 1, unitUnderTest.getImageHeight());
        assertEquals("Getter for image width", 3, unitUnderTest.getImageWidth());
        assertEquals("Getter for image height", "B", unitUnderTest.getPixelAt(new Coordinate(1, 0)));
        assertEquals("Getter for image width", "X", unitUnderTest.getPixelAt(new Coordinate(9, 9)));
    }
}