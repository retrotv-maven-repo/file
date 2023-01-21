package dev.retrotv.file.checksum;

import java.io.File;

public interface FileChecksum {
    String getChecksum(File file);
    default boolean matches(File file, String checksum) {
        if(file == null || checksum == null) {
            return false;
        }

        if(checksum.equals(this.getChecksum(file))) {
            return true;
        }

        return false;
    }
}
