package dev.retrotv.file.checksum;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

/**
 * SHA-512 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class SHA512Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) throws IOException {
        String hash = null;

        try(FileInputStream fis = new FileInputStream(Objects.requireNonNull(file))) {
            byte[] fileData = fis.readAllBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(fileData);
            hash = Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException ignored) { }

        return Optional.ofNullable(hash).orElseThrow(() -> new RuntimeException(""));
    }
}
