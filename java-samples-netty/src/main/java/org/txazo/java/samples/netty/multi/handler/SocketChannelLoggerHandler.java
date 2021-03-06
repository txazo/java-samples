package org.txazo.java.samples.netty.multi.handler;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class SocketChannelLoggerHandler extends LoggerHandler {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(SocketChannelLoggerHandler.class);

    @Override
    protected InternalLogger getLogger() {
        return LOGGER;
    }

}
