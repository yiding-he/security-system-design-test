package com.hyd.ssdt.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class AbstractController {

  public enum SessionAttr {
    User, Roles, Departments
  }

  @Autowired
  protected HttpSession httpSession;

  @SuppressWarnings("unchecked")
  protected <T> T getSessionAttribute(SessionAttr attribute) {
    return (T) httpSession.getAttribute(attribute.name());
  }

  protected void setSessionAttribute(SessionAttr attribute, Object value) {
    httpSession.setAttribute(attribute.name(), value);
  }
}
