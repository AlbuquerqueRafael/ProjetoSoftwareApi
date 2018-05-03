package com.api.pw.projsw.admin;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.SpringApplication;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
  
  @Autowired
  private ApplicationContext appContext;

  @RequestMapping(value = "/stop", method = RequestMethod.POST)
	public void stop () {
    SpringApplication.exit(appContext, () -> 0);
  }
  
}