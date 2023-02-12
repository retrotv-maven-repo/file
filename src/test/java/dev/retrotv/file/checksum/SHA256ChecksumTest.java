package dev.retrotv.file.checksum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SHA256ChecksumTest extends FileChecksumTest {

    @Test
    @DisplayName("SHA256 hash 테스트")
    void sha256Hash() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA256Checksum();
        String hash = fc.hash(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA256 hash file이 null인 경우 테스트")
    void sha256HashFileIsNull() {
        FileChecksum fc = new SHA256Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.hash(null));

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
        String checksum = fc.hash(file);

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
