package hello.upload.domain;

import java.util.List;

import lombok.Data;

@Data
public class Item {
	private Long id;
	private String itemName;
	private Uploadfile attachFile;
	private List<Uploadfile> imageFiles;
}
