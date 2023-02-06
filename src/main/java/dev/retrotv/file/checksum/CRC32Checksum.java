package dev.retrotv.file.checksum;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.zip.CRC32;

/**
 * CRC-32 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class CRC32Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) throws IOException, NullPointerException {
        Optional.ofNullable(file).orElseThrow(() -> new NullPointerException("파일 객체가 null 입니다."));

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileData = fis.readAllBytes();
            CRC32 crc32 = new CRC32();
            crc32.update(fileData);

            return Optional.ofNullable(Long.toHexString(crc32.getValue()))
                           .orElseThrow(() -> new NullPointerException("hash 값이 생성되지 않았습니다."));
        } catch (IOException e) {
            throw new IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.");
        }
    }
}
