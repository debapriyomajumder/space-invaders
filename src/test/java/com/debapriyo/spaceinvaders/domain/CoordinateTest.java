package com.debapriyo.spaceinvaders.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Coordinate}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/23/2017
 */
public class CoordinateTest {
    private Coordinate unitUnderTest;

    /**
     * Sets up this test.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        unitUnderTest = new Coordinate(5, 7);
    }

    /**
     * Tests the accessors.
     *
     * @throws Exception
     */
    @Test
    public void testAccessors() throws Exception {
        assertEquals("Getter for X", 5, unitUnderTest.getX());
        assertEquals("Getter for Y", 7, unitUnderTest.getY());
        unitUnderTest.setX(7);
        unitUnderTest.setY(5);
        assertEquals("Getter for X", 7, unitUnderTest.getX());
        assertEquals("Getter for Y", 5, unitUnderTest.getY());
    }

}