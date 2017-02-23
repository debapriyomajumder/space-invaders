package com.debapriyo.spaceinvaders.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link SpaceInvader}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/23/2017
 */
public class SpaceInvaderTest {

    private SpaceInvader unitUnderTest;

    /**
     * Sets up this test
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        unitUnderTest = new SpaceInvader();
    }

    /**
     * Test the accessors
     * 
     * @throws Exception
     */
    @Test
    public void testAccessors() throws Exception {
        assertEquals("Getter for image height", 0, unitUnderTest.getImageHeight());
        assertEquals("Getter for image width", 0, unitUnderTest.getImageWidth());
        unitUnderTest.addScanLineToImageMatrix("ABC");
        assertEquals("Getter for invalid pixel", "Y", unitUnderTest.getInvalidPixel());
        assertEquals("Getter for image height", 1, unitUnderTest.getImageHeight());
        assertEquals("Getter for image width", 3, unitUnderTest.getImageWidth());
        assertEquals("Getter for image height", "B", unitUnderTest.getPixelAt(new Coordinate(1, 0)));
        assertEquals("Getter for image width", "Y", unitUnderTest.getPixelAt(new Coordinate(9, 9)));
        assertFalse("No matches", unitUnderTest.isDetected());
        unitUnderTest.addMatch(mock(Match.class));
        assertTrue("Some matches", unitUnderTest.isDetected());
        assertTrue("ToString", unitUnderTest.toString().startsWith("The following space invader has been detected at "));
    }

}