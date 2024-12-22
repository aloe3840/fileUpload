package hello.upload.cotroller;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/servlet/v2")
public class ServletUploadControllerV2 {
	
	//    /Users/admin/study/file/t.txt
	@Value("${file.dir}")
	private String fileDir;
	
	@GetMapping("/upload")
	public String newFile() {
		return "upload-form";
	}
	
	@PostMapping("/upload")
	public String saveFile(HttpServletRequest request) throws IOException, ServletException {
		log.info("request={}", request);
		
		String itemName = request.getParameter("itemName");
		
		Collection<Part> parts = request.getParts();  // 1 요청으로 넘어온 파일 데이터 가져오기
		
		for(Part part : parts) {  // 2 파일 데이터 컬렉션에서 하나씩 추출
			log.info("=== part ===");
			log.info("name={}", part.getName());
			Collection<String> headerNames = part.getHeaderNames();
			for(String headerName : headerNames) {
				log.info("header {} : {}", headerName, part.getHeader(headerName));
			}
			//편의 메서드
			log.info("submittedFileName={}", part.getSubmittedFileName());
			log.info("size={}", part.getSize());

			//파일 데이터 읽어오기
			//InputStream inputStream = part.getInputStream();
			//String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
			//log.info("body={}", body);
			
			//파일 저장
			if(StringUtils.hasText(part.getSubmittedFileName())) { // 3 내가 제출한 파일명 있으면 아래 저장코드 수행
				// fullPath 예시
				//    /Users/admin/study/file/t.txt
				String fullPath = fileDir + part.getSubmittedFileName();  // 4 파일 저장 경로 변수에 담기
				
				log.info("파일 저장 fullPath={}", fullPath);
				part.write(fullPath); // 5 최종 파일저장 경로에 write 메서드 파람으로 넘겨서 save
			}

		}
		
		return "upload-form";
	}
	
	
	
	
	
	
	
	
}
