package com.example.myweb.dao;

import com.example.myweb.model.TestModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TestMapper {
    @Select("select id,name from test")
    List<TestModel> select();

    @Insert("insert into test(name) values(#{name})")
    int insert(@Param("name") String name);

}
