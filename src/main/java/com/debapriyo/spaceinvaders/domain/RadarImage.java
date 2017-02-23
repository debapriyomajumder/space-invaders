package com.debapriyo.spaceinvaders.domain;

/**
 * Domain representing the Radar {@link Image}.
 * 
 * @author Debapriyo Majumder (x086021)
 * @version 1.0
 * @since 2/23/2017
 */
public class RadarImage extends AbstractImage {
    private static final String INVALID = "X";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInvalidPixel() {
        return INVALID;
    }
}
