package hello.upload.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import hello.upload.domain.Uploadfile;

//파일 저장 관련 기능
@Component
public class FileStore {
	@Value("${file.dir}")
	private String fileDir;
	
	//단일 파일 업로드
	public Uploadfile storeFile(MultipartFile multipartFile) throws IllegalStateException, IOException{
		
		if(multipartFile.isEmpty()) {
			return null;
		}
		//업로드한 원본 파일명
		String originalFilename = multipartFile.getOriginalFilename();
		
		//UUID로 만든 고유파일명
		String storeFilename = createFileName(originalFilename);
		
		//파일 저장겨로 + UUID 파일명
		String fullPath = fileDir + storeFilename; 
		
		//파일 저장
		multipartFile.transferTo(new File(fullPath));
		
		return new Uploadfile(originalFilename, storeFilename);
	}
	
	
	public List<Uploadfile> storeFiles(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException{
		List<Uploadfile> storeFileResult = new ArrayList<>();
		
		for(MultipartFile file : multipartFiles) {
			if(!multipartFiles.isEmpty()) {
				storeFileResult.add(storeFile(file));
			}
		}
		return storeFileResult;
	}
	
	
	// UUID 파일 이름 생성
	private String createFileName(String originalfileName) {
		int pos = originalfileName.lastIndexOf(".");
		String ext = originalfileName.substring(pos+1);  // . 다음부터 자를 거라 .+1 (파일 확장자 떼오기)
		
		String uuid = UUID.randomUUID().toString();  //랜덤으로 만들기 (업로드 파일명이랑 상관 없음)
	
		return uuid + "." + ext; //자른 거 다시 붙이기
	}
	
	
	
	
	
}
