package com.debapriyo.spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;

/**
 * Domain representing an abstraction of the {@link Image}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/23/2017
 */
public abstract class AbstractImage implements Image {
    protected List<String> imageMatrix;

    /**
     * Constructor
     */
    public AbstractImage() {
        this.imageMatrix = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addScanLineToImageMatrix(final String scanLine) {
        this.imageMatrix.add(scanLine);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getImageHeight() {
        return this.imageMatrix.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getImageWidth() {
        return Optional.ofNullable(this.imageMatrix) //
                        .filter(CollectionUtils::isNotEmpty) //
                        .map(im -> im.get(0)) //
                        .map(String::length) //
                        .orElse(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPixelAt(final Coordinate coordinate) {
        String scanLineToReturn = getInvalidPixel();
        if (coordinate.getY() < getImageHeight() && coordinate.getX() < getImageWidth()) {
            // requested coordinates in within the image raster
            scanLineToReturn = String.valueOf(this.imageMatrix.get(coordinate.getY()).charAt(coordinate.getX()));
        }
        return scanLineToReturn;
    }
}
