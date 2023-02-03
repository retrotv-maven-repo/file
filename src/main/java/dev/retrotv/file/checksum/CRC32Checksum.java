package dev.retrotv.file.checksum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;

public class CRC32Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) {
        String hash = null;

        try(FileInputStream fis = new FileInputStream(file)) {
            CRC32 crc32 = new CRC32();
            byte[] fileData = fis.readAllBytes();

            crc32.update(fileData);
            hash = Long.toHexString(crc32.getValue());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}
