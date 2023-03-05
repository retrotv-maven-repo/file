package dev.retrotv.file.checksum;

import dev.retrotv.file.checksum.sha.SHA224Checksum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SHA224ChecksumTest extends FileChecksumTest {

    @Test
    @DisplayName("SHA224 hash 테스트")
    void sha256Hash() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA224Checksum();
        String hash = fc.checksum(file);

        logger.debug("hash 값: " + hash);

        assertNotNull(hash);
    }

    @Test
    @DisplayName("SHA224 hash file이 null인 경우 테스트")
    void sha256HashFileIsNull() {
        FileChecksum fc = new SHA224Checksum();
        Throwable throwable = assertThrows(NullPointerException.class, () -> fc.checksum(null));

        assertEquals("파일 객체가 null 입니다.", throwable.getMessage());
    }

    @Test
    @DisplayName("SHA224 matches 테스트")
    void sha256Matches() throws IOException {
        File file;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        FileChecksum fc = new SHA224Checksum();
        String checksum = fc.checksum(file);

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
