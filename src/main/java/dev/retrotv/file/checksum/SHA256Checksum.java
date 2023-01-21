package dev.retrotv.file.checksum;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Checksum implements FileChecksum {

    @Override
    public String getChecksum(File file) {
        String hash = null;

        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] fileData = fis.readAllBytes();
            MessageDigest md = MessageDigest.getInstance("SHA256");
            md.update(fileData);
            hash = Hex.encodeHexString(md.digest());
        } catch(IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}
