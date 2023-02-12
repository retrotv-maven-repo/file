package dev.retrotv.file.checksum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FileChecksumTest {
    protected static final Logger logger = LoggerFactory.getLogger(FileChecksumTest.class);
    protected final URL resource = this.getClass().getClassLoader().getResource("Usb_connectors.JPG");
    protected final URL resource2 = this.getClass().getClassLoader().getResource("Usb_connectors2.JPG");
}
