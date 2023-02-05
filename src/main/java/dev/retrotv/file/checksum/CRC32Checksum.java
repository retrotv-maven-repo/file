package dev.retrotv.file.checksum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/**
 * CRC-32 알고리즘을 사용하는 {@link FileChecksum} 인터페이스 구현체입니다.
 * @author yjj8353
 */
public class CRC32Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] fileData = fis.readAllBytes();
        fis.close();

        CRC32 crc32 = new CRC32();
        crc32.update(fileData);

        return Long.toHexString(crc32.getValue());
    }
}
