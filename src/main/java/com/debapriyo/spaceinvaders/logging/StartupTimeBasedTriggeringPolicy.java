package com.debapriyo.spaceinvaders.logging;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import ch.qos.logback.core.rolling.RolloverFailure;

/**
 * Custom rollover policy to trigger rollover every time the application starts up.
 *
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/19/2017
 */
@NoAutoStart
public class StartupTimeBasedTriggeringPolicy<E> extends DefaultTimeBasedFileNamingAndTriggeringPolicy<E> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        super.start();
        nextCheck = 0L;
        isTriggeringEvent(null, null);
        try {
            tbrp.rollover();
        }
        catch (RolloverFailure e) {
            // Do nothing
        }
    }

}
