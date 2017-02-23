package com.debapriyo.spaceinvaders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.debapriyo.spaceinvaders.domain.SpaceInvader;
import com.debapriyo.spaceinvaders.holder.KnownSpaceInvadersHolder;
import com.debapriyo.spaceinvaders.processor.RadarImageProcessor;

/**
 * End to end Integration Test.
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class IntegrationTest {
    /**
     * End to end integration test.
     * 
     * @throws Exception
     */
    @Test
    public void integrationTest() throws Exception {
        RadarImageProcessor.INSTANCE.process();
        SpaceInvader spaceInvaderOne = KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(0);
        assertTrue("Space Invader one has been detected", spaceInvaderOne.isDetected());
        SpaceInvader spaceInvaderTwo = KnownSpaceInvadersHolder.INSTANCE.getKnownSpaceInvaders().get(1);
        assertFalse("Space Invader two has not been detected", spaceInvaderTwo.isDetected());
    }

}