package itcampus.com.config;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class SymbolicLinkConfig {
	Logger logger=LoggerFactory.getLogger(SymbolicLinkConfig.class);
	
	 @PostConstruct
    public void createSymbolicLink() {
        Path target = Paths.get("/home/itcampus/production/file");
        Path link = Paths.get("src/main/resources/static/file").toAbsolutePath();

        try {
            // 기존 심볼릭 링크가 존재하면 삭제
//	            if (Files.exists(link)) {
//	                Files.delete(link);
//	            }
        	// 기존 심볼릭 링크 또는 디렉토리가 존재하면 삭제
            if (Files.exists(link)) {
                if (Files.isDirectory(link)) {
                    deleteDirectoryContents(link);
                } else {
                    Files.delete(link);
                }
            }
            // 새로운 심볼릭 링크 생성
            Files.createSymbolicLink(link, target);
            System.out.println("심볼릭 링크가 성공적으로 생성되었습니다!");
            logger.debug("심볼릭 링크가 성공적으로 생성되었습니다!");
        } catch (FileAlreadyExistsException e) {
            System.err.println("심볼릭 링크가 이미 존재합니다: " + e.getMessage());
            logger.debug("심볼릭 링크가 이미 존재합니다: " + e.getMessage());
        } catch (AccessDeniedException e) {
            System.err.println("권한이 부족합니다. 관리자 권한으로 실행하세요.");
            logger.debug("권한이 부족합니다. 관리자 권한으로 실행하세요.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 
	 private void deleteDirectoryContents(Path directory) throws IOException {
	        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
	            for (Path path : directoryStream) {
	                if (Files.isDirectory(path)) {
	                    deleteDirectoryContents(path);
	                }
	                Files.delete(path);
	            }
	        }
	    }
}
