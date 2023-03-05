package dev.retrotv.file.checksum.sha;

import dev.retrotv.crypt.owe.sha.SHA1;
import dev.retrotv.file.checksum.FileChecksum;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * SHA-1 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class SHA1Checksum extends FileChecksum {

    @Override
    public String checksum(File file) throws IOException, NullPointerException {
        Optional.ofNullable(file).orElseThrow(() -> new NullPointerException("파일 객체가 null 입니다."));
        byte[] fileData = readFile(file);
        byte[] hashData = hash(fileData, new SHA1());

        return DatatypeConverter.printHexBinary(hashData).toLowerCase();
    }
}
