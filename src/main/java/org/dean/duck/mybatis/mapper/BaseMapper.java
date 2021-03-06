package org.dean.duck.mybatis.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.dean.duck.mybatis.model.Emp;

import java.util.List;

/**
 * @description:
 * @author: dean
 * @create: 2019/07/14 19:06
 */
public interface BaseMapper {

	@Select({"select * from emp"})
	List<Emp> list();

	@Insert({"insert into emp(name,deg,salary,dept) values(#{name},#{deg},#{salary},#{dept})"})
	int insert(Emp emp);
}
