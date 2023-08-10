package com.hyd.ssdt.security;

import com.hyd.ssdt.controllers.AbstractController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (request.getRequestURI().equals("/sign-in")
        || request.getRequestURI().equals("/")) {
      return true;
    }

    var userAttrName = AbstractController.SessionAttr.User.name();
    if (request.getSession().getAttribute(userAttrName) == null) {
      response.sendRedirect("/");
      return false;
    }
    return true;
  }
}
