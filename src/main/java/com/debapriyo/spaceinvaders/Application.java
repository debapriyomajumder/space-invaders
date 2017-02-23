package com.debapriyo.spaceinvaders;

import com.debapriyo.spaceinvaders.processor.RadarImageProcessor;

/**
 * The application startup.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public class Application {
    /**
     * Starts up the application.
     * 
     * @param args array of command line arguments.
     */
    public static void main(final String args[]) {
        RadarImageProcessor.INSTANCE.process();
    }
}
