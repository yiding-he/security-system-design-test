package com.hyd.ssdt.controllers;

import com.hyd.hybatis.Conditions;
import com.hyd.hybatis.row.Row;
import com.hyd.ssdt.mappers.UserDepartmentMapper;
import com.hyd.ssdt.mappers.UserMapper;
import com.hyd.ssdt.mappers.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController extends AbstractController {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserRoleMapper userRoleMapper;

  @Autowired
  private UserDepartmentMapper userDepartmentMapper;

  @RequestMapping("/")
  public ModelAndView index() {
    return new ModelAndView("/index")
      .addObject("users", userMapper.selectAll());
  }

  @RequestMapping("/sign-out")
  public ModelAndView signOut() {
    removeSessionAttribute(SessionAttr.User);
    removeSessionAttribute(SessionAttr.Roles);
    removeSessionAttribute(SessionAttr.Departments);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping("/sign-in")
  public ModelAndView signIn(
    @RequestParam("user") String userName
  ) {
    var user = userMapper.selectOne(
      Conditions.eq("name", userName)
    );
    if (user == null) {
      throw new IllegalArgumentException("User not found");
    }

    var sysUserId = user.getString("sys_user_id");
    setSessionAttribute(SessionAttr.User, user);
    setSessionAttribute(SessionAttr.Roles, queryRoles(sysUserId));
    setSessionAttribute(SessionAttr.Departments, queryDepartments(sysUserId));

    return new ModelAndView("redirect:/home");
  }

  private List<Row> queryDepartments(String sysUserId) {
    return userDepartmentMapper.selectDepartmentsByUser(
      Conditions.eq("sys_user_id", sysUserId).projection("sys_dept_id", "name")
    );
  }

  private List<Row> queryRoles(String sysUserId) {
    return userRoleMapper.selectRolesByUser(
      Conditions.eq("sys_user_id", sysUserId).projection("sys_role_id", "name")
    );
  }

  @RequestMapping("/home")
  public ModelAndView home() {
    return new ModelAndView("/home");
  }
}
