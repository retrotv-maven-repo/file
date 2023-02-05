package dev.retrotv.file.checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 파일 체크섬 생성 및 비교를 위한 인터페이스 입니다.
 * @author yjj8353
 */
public interface FileChecksum {

    Logger logger = LoggerFactory.getLogger(FileChecksum.class);

    /**
     * 파일의 체크섬을 생성하고 반환합니다.
     * @param file 체크섬을 생성할 {@link java.io.File} 객체
     * @return 생성된 체크섬 값
     */
    String getChecksum(File file) throws IOException;

    /**
     * 파일의 체크섬과 기존의 체크섬 값이 일치하는지 확인 합니다.
     * @param file 체크섬을 생성할 {@link java.io.File} 객체
     * @param checksum 비교할 체크섬 값
     * @return 두 체크섬 값이 일치할 경우 true, 일치하지 않을 경우 false 반환
     */
    default boolean matches(File file, String checksum) throws IOException {
        if(file == null || checksum == null) {
            return false;
        }

        String fileChecksum = this.getChecksum(file);

        logger.debug("1st Checksum: {}", fileChecksum);
        logger.debug("2nd Checksum: {}", checksum);

        return checksum.equals(fileChecksum);
    }

    /**
     * 두 파일의 체크섬이 일치하는지 확인 합니다.
     * @param file1 체크섬을 생성할 첫 번째 {@link java.io.File} 객체
     * @param file2 체크섬을 생성할 두 번째 {@link java.io.File} 객체
     * @return 두 체크섬 값이 일치할 경우 true, 일치하지 않을 경우 false 반환
     */
    default boolean matches(File file1, File file2) throws IOException {
        if(file1 == null || file2 == null) {
            return false;
        }

        String file1Checksum = this.getChecksum(file1);
        String file2Checksum = this.getChecksum(file2);

        logger.debug("1st Checksum: {}", file1Checksum);
        logger.debug("2nd Checksum: {}", file2Checksum);

        return file1Checksum.equals(file2Checksum);
    }
}
