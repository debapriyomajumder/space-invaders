package com.debapriyo.spaceinvaders.domain;

/**
 * Base interface for any kind or raster scan image
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/23/2017
 */
public interface Image {

    /**
     * Adds a scan line to the {@link Image} image raster
     *
     * @param scanLine the scan line to add
     */
    void addScanLineToImageMatrix(final String scanLine);

    /**
     * @return the image height for this {@link Image}
     */
    int getImageHeight();

    /**
     * @return the image width for this {@link Image}
     */
    int getImageWidth();

    /**
     * Returns the pixel at the location described by the {@link Coordinate} {@code coordinate} within the area of this <br/>
     * {@link Image} raster scan area. If the requested location is not within the scan area then an pixel <br/>
     * (defined per {@link Image} implementation) is returned.
     *
     * @param coordinate the {@link Coordinate}
     * @return the pixel as a {@link String}
     */
    String getPixelAt(final Coordinate coordinate);

    /**
     * Returns the invalid pixel to be defined by the concrete implementation.
     * 
     * @return the invalid pixel
     */
    String getInvalidPixel();
}
