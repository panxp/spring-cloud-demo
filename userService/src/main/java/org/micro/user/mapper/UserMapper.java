package org.micro.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.micro.user.entity.User;


@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User selectbyid(int id);
}

