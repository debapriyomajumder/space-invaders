package com.debapriyo.spaceinvaders.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Match}.s
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class MatchTest {

    private Match unitUnderTest;
    private Coordinate mockCoordidate;

    /**
     * Sets up this test.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        mockCoordidate = mock(Coordinate.class);
        unitUnderTest = new Match(50, mockCoordidate);
    }

    /**
     * Tests the accessors
     *
     * @throws Exception
     */
    @Test
    public void testAccessors() throws Exception {
        assertEquals("Getter for coordinate", mockCoordidate, unitUnderTest.getMatchedAt());
        assertEquals("Getter for percentage matched", 50, unitUnderTest.getPercentageMatched());
        unitUnderTest.setMatchedAt(null);
        unitUnderTest.setPercentageMatched(70);
        assertNull("Getter for coordinate", unitUnderTest.getMatchedAt());
        assertEquals("Getter for percentage matched", 70, unitUnderTest.getPercentageMatched());
    }

}