package com.hyd.ssdt.mappers;

import com.hyd.hybatis.Conditions;
import com.hyd.hybatis.annotations.HbMapper;
import com.hyd.hybatis.mapper.CrudMapper;
import com.hyd.hybatis.row.Row;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@HbMapper(table = "sys_user")
public interface UserMapper extends CrudMapper<Row> {

  default List<Row> selectAll() {
    return selectList(new Conditions());
  }
}
