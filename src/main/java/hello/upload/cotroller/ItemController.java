package hello.upload.cotroller;

import java.nio.file.FileStore;

import org.springframework.stereotype.Controller;

import hello.upload.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {
	private final ItemRepository itemRepository;
	private final FileStore fileStore;
	
	//등록폼 
	//getMapping("/items/new")
	
	//등록폼에서 데이터 저장하고 저장한 화면으로 리다이렉트
	//postMapping("/items/new")
	
	//상품 보여주기
	//getMapping("/item/{id}")
	
	
	
	
}
