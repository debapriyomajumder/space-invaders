package com.debapriyo.spaceinvaders.domain;

import static com.debapriyo.spaceinvaders.domain.SpaceInvaderTest.SPACE_INVADER_TEST_PATTERN;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ScanLine}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/19/2017
 */
public class ScanLineTest {

    private ScanLine unitUnderTest;
    private SpaceInvader spaceInvader;

    /**
     * Sets up this test.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        unitUnderTest = new ScanLine();
        spaceInvader = new SpaceInvader(SPACE_INVADER_TEST_PATTERN);
    }

    /**
     * Checks for space invaders in the scan line when: <br/>
     * Scenario: Space invader is present multiple times.
     * 
     * @throws Exception
     */
    @Test
    public void checkForSpaceInvaderTestOne() throws Exception {
        unitUnderTest.append("--0-00000--00-0000--00-");
        unitUnderTest.checkForSpaceInvader(spaceInvader);
        assertEquals("Number of occurrences of this space invader", "Space Invader of type \"" + SPACE_INVADER_TEST_PATTERN + "\" detected 2 times", spaceInvader.toString());
    }

    /**
     * Checks for space invaders in the scan line when: <br/>
     * Scenario: Space invader is present once.
     *
     * @throws Exception
     */
    @Test
    public void checkForSpaceInvaderTestTwo() throws Exception {
        unitUnderTest.append("--0-00000--00-0000--0-0-");
        unitUnderTest.checkForSpaceInvader(spaceInvader);
        assertEquals("Number of occurrences of this space invader", "Space Invader of type \"" + SPACE_INVADER_TEST_PATTERN + "\" detected 1 times", spaceInvader.toString());
    }

    /**
     * Checks for space invaders in the scan line when: <br/>
     * Scenario: Space invader is not present at all.
     *
     * @throws Exception
     */
    @Test
    public void checkForSpaceInvaderTestThree() throws Exception {
        unitUnderTest.append("--0-00000--0-0-0000--0-0-");
        unitUnderTest.checkForSpaceInvader(spaceInvader);
        assertEquals("Number of occurrences of this space invader", "Space Invader of type \"" + SPACE_INVADER_TEST_PATTERN + "\" detected 0 times", spaceInvader.toString());
    }
}