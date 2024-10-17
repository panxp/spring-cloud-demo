package org.micro.user2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.micro.user2.entity.User;


@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User selectbyid(int id);
}

