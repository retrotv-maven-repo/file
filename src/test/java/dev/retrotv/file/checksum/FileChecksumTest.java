package dev.retrotv.file.checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class FileChecksumTest {
    protected static final Logger logger = LoggerFactory.getLogger(FileChecksumTest.class);
    protected final URL resource = this.getClass().getClassLoader().getResource("Usb_connectors.JPG");
    protected final URL resource2 = this.getClass().getClassLoader().getResource("Usb_connectors2.JPG");
}
