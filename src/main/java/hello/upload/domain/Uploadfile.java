package hello.upload.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Uploadfile {
	private String uploadFileName;  //사용자가 입력한 파일명 (중복될 수 있음)
	private String storeFileName;   //실제 저장되는 파일명 (UUID같은 고유값으로 저장해야함)
	
}
