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
    private static final Logger logger = LoggerFactory.getLogger(FileChecksumTest.class);
    private final URL resource = this.getClass().getClassLoader().getResource("Usb_connectors.JPG");
    private final URL resource2 = this.getClass().getClassLoader().getResource("Usb_connectors2.JPG");

    @Test
    @DisplayName("CRC32 getChecksum 테스트")
    void crc32GetChecksum() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new CRC32Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("CRC32 getChecksum file이 null인 경우 테스트")
    void crc32GetChecksumFileIsNull() {
        FileChecksum fc = new CRC32Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.getChecksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("CRC32 matches 테스트")
    void crc32Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new CRC32Checksum();
        String checksum = fc.getChecksum(file);

        logger.debug("checksum: " + checksum);
        assertNotNull(checksum);

        boolean isSameFile = fc.matches(file, checksum);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);

        File file2;
        try {
            file2 = new File(Objects.requireNonNull(resource2).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        isSameFile = fc.matches(file, file2);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("MD5 getChecksum 테스트")
    void md5GetChecksum() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new MD5Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("MD5 getChecksum file이 null인 경우 테스트")
    void md5GetChecksumFileIsNull() {
        FileChecksum fc = new MD5Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.getChecksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("MD5 matches 테스트")
    void md5Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
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

        File file2;
        try {
            file2 = new File(Objects.requireNonNull(resource2).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        isSameFile = fc.matches(file, file2);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("SHA1 getChecksum 테스트")
    void sha1GetChecksum() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA1Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA1 getChecksum file이 null인 경우 테스트")
    void sha1GetChecksumFileIsNull() {
        FileChecksum fc = new SHA1Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.getChecksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("SHA1 matches 테스트")
    void sha1Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
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

        File file2;
        try {
            file2 = new File(Objects.requireNonNull(resource2).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        isSameFile = fc.matches(file, file2);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("SHA256 getChecksum 테스트")
    void sha256GetChecksum() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA256Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA256 getChecksum file이 null인 경우 테스트")
    void sha256GetChecksumFileIsNull() {
        FileChecksum fc = new SHA256Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.getChecksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("SHA256 matches 테스트")
    void sha256Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
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

        File file2;
        try {
            file2 = new File(Objects.requireNonNull(resource2).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        isSameFile = fc.matches(file, file2);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }

    @Test
    @DisplayName("SHA512 getChecksum 테스트")
    void sha512GetChecksum() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA512Checksum();
        String hash = fc.getChecksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA512 getChecksum file이 null인 경우 테스트")
    void sha512GetChecksumFileIsNull() {
        FileChecksum fc = new SHA512Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.getChecksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("SHA512 matches 테스트")
    void sha512Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA512Checksum();
        String checksum = fc.getChecksum(file);

        logger.debug("checksum: " + checksum);
        assertNotNull(checksum);

        boolean isSameFile = fc.matches(file, checksum);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);

        File file2;
        try {
            file2 = new File(Objects.requireNonNull(resource2).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        isSameFile = fc.matches(file, file2);
        logger.debug("same file: " + isSameFile);

        assertTrue(isSameFile);
    }
}
