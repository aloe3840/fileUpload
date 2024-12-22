package hello.upload.cotroller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//상품 저장용 폼
@Data
public class ItmeForm {
	private Long itemId;
	private String itemName;
	private List<MultipartFile> imagesFiles;  //이미지 다중 업로드
	private MultipartFile attachFile; //@ModelAttribute 사용 가능
	
	
	
}
