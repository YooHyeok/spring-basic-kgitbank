package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.MessageService;
import org.zerock.vo.MessageVO;

@RestController
@RequestMapping("/message")//컨트롤러 자체에 매핑주소 등록
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	//메시지 추가
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		
		ResponseEntity<String> entity = null;
		
		try {
			this.messageService.addMessage(vo);//메시지 추가
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
}
