package com.api.pw.projsw.admin;

import org.springframework.web.bind.annotation.RestController;

import com.api.pw.projsw.frontend.FrontEnd;
import com.api.pw.projsw.frontend.FrontEndService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.SpringApplication;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
  
  @Autowired
  private ApplicationContext appContext;

  @Autowired
  private FrontEndService frontEndService;

  @RequestMapping(value = "/stop", method = RequestMethod.POST)
	public void stop (@RequestBody FrontEnd admin) {
    frontEndService.checkAdmin(admin);
    SpringApplication.exit(appContext, () -> 0);
  }
  
}