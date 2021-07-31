package org.txazo.java.samples.lombok.cleanup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    public void write(File file, String content) throws IOException {
        FileWriter writer = new FileWriter(file);
        try {
            writer.write(content);
        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }

}
