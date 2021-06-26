package org.txazo.java.samples.netty.multi;

import io.netty.channel.ChannelHandler;

public interface Client {

    void addHandler(ChannelHandler... handlers);

}
