package com.yuexin.dao;

import com.yuexin.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-9-26
 * Time: 上午8:24
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int findUser(User user){
        return jdbcTemplate.queryForInt("select count(*) from user where name = '"+user.getName()+"' and password= '"+user.getPassword()+"'");
    }
}
