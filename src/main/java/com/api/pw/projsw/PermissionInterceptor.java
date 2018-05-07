package com.api.pw.projsw;


import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.pw.projsw.frontend.FrontEnd;
import com.api.pw.projsw.frontend.FrontEndService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
 
  @Autowired
  private FrontEndService frontEnd;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
          throws Exception {
      
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      Method method = handlerMethod.getMethod();
      String requestURI = request.getRequestURI();
      
      if (requestURI.contains("/admin/stop") || 
          (requestURI.contains("frontend") && method.getName().equals("save"))) {
        String id = request.getParameter("id");
        String secret =  request.getParameter("secret");

        frontEnd.checkAdmin(new FrontEnd(id, secret));
      }
  

      return true;
  }


}