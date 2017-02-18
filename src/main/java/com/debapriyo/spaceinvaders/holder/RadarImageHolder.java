package com.debapriyo.spaceinvaders.holder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The holder for the radar image file.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/18/2017
 */
public enum RadarImageHolder {
    INSTANCE;

    /**
     * Returns a {@link Stream} of {@link String} "lines" from the radar image file. Nice thing is the file is read as and when and how the stream is consumed.
     * 
     * @return {@link Stream} of {@link String} lines
     * @throws IOException if the file could not be closed or there was an error while reading the file
     */
    public Stream<String> getRadarImageScanLinesStream() throws IOException {
        String fileName = Optional.ofNullable(getClass().getClassLoader().getResource(PropertiesHolder.INSTANCE.getRadarImageFileName())) //
                        .map(URL::getFile) //
                        .orElse(null);
        File file = new File(fileName);
        return Files.lines(file.toPath());
    }
}
