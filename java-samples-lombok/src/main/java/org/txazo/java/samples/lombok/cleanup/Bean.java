package org.txazo.java.samples.lombok.cleanup;

import lombok.Cleanup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class Bean {

    public void write(File file, String content) throws IOException {
        @Cleanup FileWriter writer = new FileWriter(file);
        writer.write(content);
    }

}
