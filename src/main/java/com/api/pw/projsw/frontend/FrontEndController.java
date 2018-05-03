package com.api.pw.projsw.frontend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api")
public class FrontEndController {
	
  @Autowired
  private FrontEndService frontEndService;

  @RequestMapping(value = "/frontend", method = RequestMethod.GET)
	public List<FrontEnd> getAll () {
		return frontEndService.getAll();
  }

  @RequestMapping(value = "/frontend", method = RequestMethod.POST)
  public ResponseEntity<Map<String, String>> save (@RequestBody FrontEnd frontend,
                                                   @ModelAttribute FrontEnd admin) {
    frontEndService.checkAdmin(admin);
    Map<String, String> response = frontEndService.save(frontend);

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
  }
  
}