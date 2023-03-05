package dev.retrotv.file.checksum.sha;

import dev.retrotv.crypt.owe.sha.SHA384;
import dev.retrotv.file.checksum.FileChecksum;

import javax.xml.bind.DatatypeConverter;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

/**
 * SHA-512 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class SHA384Checksum implements FileChecksum {

    @Override
    public String hash(File file) throws IOException, NullPointerException {
        String hash;
        Optional.ofNullable(file).orElseThrow(() -> new NullPointerException("파일 객체가 null 입니다."));

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(file.toPath()))) {
            byte[] fileData = new byte[(int) file.length()];
            dis.readFully(fileData);

            SHA384 sha = new SHA384();
            hash = DatatypeConverter.printHexBinary(sha.encrypt(fileData)).toLowerCase();
        } catch (IOException e) {
            throw new IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.");
        }

        return Optional.of(hash).orElseThrow(() -> new NullPointerException("hash 값이 생성되지 않았습니다."));
    }
}
