package hello.upload.cotroller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/spring")
public class SpringUploadController {
	
	@Value("${file.dir}")  //빈 주입
	private String fileDir;
	
	@GetMapping("/upload")
	public String newFile() {
		return "upload-form";
	}
	
	//MultiPartFile 객체의 주요메서드
	//file.getOriginalFilename() : 업로드 파일명
	//file.transferTo() : 파일 저장
	
	
	@PostMapping("/upload")
	public String saveFile(@RequestParam("itemName") String itemName,
						   @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.isEmpty()) {
			String fullPath = fileDir + file.getOriginalFilename();  //아까의 submitFileName
			file.transferTo(new File(fullPath)); //아까의 part.write 
		}
		
		return "upload-form";
		
	}
	
	
	
	
	
	
}
