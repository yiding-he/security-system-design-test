package com.hyd.ssdt.mappers;

import com.hyd.hybatis.Conditions;
import com.hyd.hybatis.annotations.HbSelect;
import com.hyd.hybatis.row.Row;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDepartmentMapper {

  @HbSelect(table = """
    SELECT
      sys_user.sys_user_id, sys_dept.*
    FROM sys_user, sys_dept, sys_user_dept_rel AS rel
    WHERE rel.sys_user_id = sys_user.sys_user_id
      AND rel.sys_dept_id = sys_dept.sys_dept_id""")
  List<Row> selectDepartmentsByUser(Conditions conditions);
}
