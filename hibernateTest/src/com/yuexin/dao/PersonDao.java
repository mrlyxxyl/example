package com.yuexin.dao;

import com.yuexin.bean.Student;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-13
 * Time: ����11:47
 * To change this template use File | Settings | File Templates.
 */
public interface PersonDao {

    /**
     * �����û�
     * @param person
     */
    void save(Student person);
}
