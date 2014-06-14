package com.yuexin.dao;

import com.yuexin.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface User2Dao {
    @Select("select id,name,first_name as firstName from user where id = #{id}")
    User getUserById2(@Param("id") int id);
}
