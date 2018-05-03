package com.api.pw.projsw.frontend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api")
public class FrontEndController {
	
  @Autowired
  FrontEndService frontEndService;
  
  @RequestMapping(value = "/frontend", method = RequestMethod.GET)
	public List<FrontEnd> getAll () {
		return frontEndService.getAll();
  }
  
}