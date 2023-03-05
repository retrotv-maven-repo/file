package dev.retrotv.file.checksum.crc;

import dev.retrotv.crypt.owe.crc.CRC32;
import dev.retrotv.file.checksum.FileChecksum;

import javax.xml.bind.DatatypeConverter;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

/**
 * CRC-32 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class CRC32Checksum implements FileChecksum {

    @Override
    public String hash(File file) throws IOException, NullPointerException {
        Optional.ofNullable(file).orElseThrow(() -> new NullPointerException("파일 객체가 null 입니다."));

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(file.toPath()))) {
            byte[] fileData = new byte[(int) file.length()];
            dis.readFully(fileData);

            CRC32 crc32 = new CRC32();
            byte[] encrytedData = crc32.encrypt(fileData);

            return DatatypeConverter.printHexBinary(encrytedData).toLowerCase();
        } catch (IOException e) {
            throw new IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.");
        }
    }
}
