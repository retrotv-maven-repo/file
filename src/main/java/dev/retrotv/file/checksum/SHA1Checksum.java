package dev.retrotv.file.checksum;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA-1 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class SHA1Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) throws IOException {
        String hash;

        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] fileData = fis.readAllBytes();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(fileData);
            hash = Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}
