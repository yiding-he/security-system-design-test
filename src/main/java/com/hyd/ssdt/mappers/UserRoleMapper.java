package com.hyd.ssdt.mappers;

import com.hyd.hybatis.Conditions;
import com.hyd.hybatis.annotations.HbSelect;
import com.hyd.hybatis.row.Row;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

  @HbSelect(table = """
    SELECT
      sys_user.sys_user_id,
      sys_role.*
    FROM sys_user, sys_role, sys_user_role_rel AS rel
    WHERE rel.sys_user_id = sys_user.sys_user_id
      AND rel.sys_role_id = sys_role.sys_role_id""")
  List<Row> selectRolesByUser(Conditions conditions);
}
