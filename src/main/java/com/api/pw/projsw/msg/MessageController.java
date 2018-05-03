package com.api.pw.projsw.msg;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import com.api.pw.projsw.frontend.FrontEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api")
public class MessageController {
	
  @Autowired
  MessageRepository messageRepository;

  @Autowired
  MessageService messageService;

  @RequestMapping(value = "/msgs", method = RequestMethod.GET)
	public List<Message> getAll () {
		return messageService.getAll();
  }
    
  @RequestMapping(value = "/msgs", method = RequestMethod.POST)
  public ResponseEntity<Map<String, String>> save (@RequestBody Message msg) {
    Map<String, String> response = messageService.save(msg);

    return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
  }
    
  @RequestMapping(value = "/msgs/{id}", method = RequestMethod.GET)
  public MessageDTO getById (@PathVariable("id") Long id) {
    return messageService.getById(id);
  }	
    
  @RequestMapping(value = "/msgs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Map<String, String>> delete (@RequestBody FrontEnd credentials, 
                                                     @PathVariable("id") Long id) { 

    Map<String, String> response = messageService.delete(id, credentials);
   
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}	
	
}