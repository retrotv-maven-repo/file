import dev.retrotv.file.checksum.FileChecksum;
import dev.retrotv.file.checksum.MD5Checksum;
import dev.retrotv.file.checksum.SHA1Checksum;
import dev.retrotv.file.checksum.SHA256Checksum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class FileChecksumTest {
    private static final Logger logger = LoggerFactory.getLogger(FileChecksumTest.class);
    private final URL resource = this.getClass().getClassLoader().getResource("Usb_connectors.JPG");

    @Test
    @DisplayName("MD5 getChecksum 테스트")
    void md5GetChecksum() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new MD5Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("MD5 matches 테스트")
    void md5Matches() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new MD5Checksum();
        String checksum = fc.getChecksum(file);

        logger.debug("checksum: " + checksum);
        assertNotNull(checksum);

        boolean isSameFile = fc.matches(file, checksum);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("SHA1 getChecksum 테스트")
    void sha1GetChecksum() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA1Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA1 matches 테스트")
    void sha1Matches() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA1Checksum();
        String checksum = fc.getChecksum(file);

        logger.debug("checksum: " + checksum);
        assertNotNull(checksum);

        boolean isSameFile = fc.matches(file, checksum);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("SHA256 getChecksum 테스트")
    void sha256GetChecksum() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA256Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA256 matches 테스트")
    void sha256Matches() {
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA256Checksum();
        String checksum = fc.getChecksum(file);

        logger.debug("checksum: " + checksum);
        assertNotNull(checksum);

        boolean isSameFile = fc.matches(file, checksum);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }
}
