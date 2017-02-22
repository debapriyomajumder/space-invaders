package com.debapriyo.spaceinvaders.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link SpaceInvader}
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/19/2017
 */
public class SpaceInvaderTest {
    public static final String SPACE_INVADER_TEST_PATTERN = "-00-";
    private SpaceInvader unitUnderTest;

    /**
     * Sets up this test.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        // unitUnderTest = new SpaceInvader(SPACE_INVADER_TEST_PATTERN);
        // unitUnderTest.detected();
    }

    /**
     * Tests the getter for space invader pattern property.
     * 
     * @throws Exception
     */
    @Test
    public void getInvaderPattern() throws Exception {
        // assertEquals("Space Invader pattern", SPACE_INVADER_TEST_PATTERN, unitUnderTest.getInvaderPattern());
    }

    /**
     * Tests the toString() method.
     * 
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        assertEquals("Space Invader toString()", "Space Invader of type \"" + SPACE_INVADER_TEST_PATTERN + "\" detected 1 times", unitUnderTest.toString());
    }

}