package com.debapriyo.spaceinvaders.holder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.debapriyo.spaceinvaders.domain.SpaceInvader;

/**
 * Unit test for {@link KnownSpaceInvadersHolder}.
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class KnownSpaceInvadersHolderTest {

    /**
     * Tests the enum, whether it is able to read the file properly.
     * 
     * @throws Exception
     */
    @Test
    public void getKnownSpaceInvaders() throws Exception {
        assertEquals("Known space invader list size", 2, KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().size());
        SpaceInvader spaceInvaderOne = KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(0);
        assertEquals("Known space invader one width", 11, spaceInvaderOne.getImageWidth());
        assertEquals("Known space invader one height", 8, spaceInvaderOne.getImageHeight());
        SpaceInvader spaceInvaderTwo = KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(1);
        assertEquals("Known space invader two width", 8, spaceInvaderTwo.getImageWidth());
        assertEquals("Known space invader two height", 8, spaceInvaderTwo.getImageHeight());
    }

}