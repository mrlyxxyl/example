package com.wdl.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.wdl.model.TandS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cm.wdl.dao.StudentDao;

import com.wdl.model.Student;

public class StudentDaoImpl {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        Reader reader = null;
        try {
            reader = org.apache.ibatis.io.Resources
                    .getResourceAsReader("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public void insertStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("insertStudent", student);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }


    public void updateStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("updateStudent", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @SuppressWarnings("unchecked")

    public List<Student> queryAllStudent() {
        List<Student> students = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            students = sqlSession.selectList("selectAllStudent");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return students;
    }


    @SuppressWarnings("unchecked")
    public List<Student> queryStudentLikeName(String name) {
        List<Student> students = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Student> selectList = sqlSession.selectList("queryStudentLikeName", name);
            students = selectList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return students;
    }


    @Select("select t.id,t.username,t.password,t.birthday,s.id,s.username,s.password,s.birthday from student s,teacher t where s.id = t.id and s.id = #{sid}")
    public List<TandS> selectTSBySid(@Param("sid") int sid) {
        return null;
    }


}
