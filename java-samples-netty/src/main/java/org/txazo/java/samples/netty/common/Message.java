package org.txazo.java.samples.netty.common;

public class Message {

    private int id;

    private long time;

    public Message(int id, long time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

}
