package com.debapriyo.spaceinvaders.holder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link KnownSpaceInvadersHolder}
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/19/2017
 */
public class KnownSpaceInvadersHolderTest {

    /**
     * Tests the getter for the list of known space invaders
     * 
     * @throws Exception
     */
    @Test
    public void getKnownSpaceInvaders() throws Exception {
        assertEquals("Size of the list of known space invaders", 16, KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().size());
        assertEquals("First element in the list of known space invaders", "--o-----o--", KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(0).getInvaderPattern());
        assertEquals("Last element in the list of known space invaders", "o-o--o-o", KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(15).getInvaderPattern());
    }

}