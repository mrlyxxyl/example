package com.wdl.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.wdl.dao.impl.StudentDaoImpl;
import com.wdl.model.Student;

import cm.wdl.dao.StudentDao;
import com.wdl.model.TandS;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test extends TestCase {

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

    @org.junit.Test
    public void testInsertStudent() {
      /*  StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(2);
        student.setBirthday(new Date());
        student.setPassword("passwddfgdsaford");
        student.setUsername("userndsaame");
        studentDao.insertStudent(student);*/
    }

    @org.junit.Test
    public void testselectStudent() {
       /* StudentDao studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.queryStudentLikeName("%aame%");
        System.out.println(list.size());*/
    }

    @org.junit.Test
    public void testQueryAllStudent() {
      /*  StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryAllStudent();
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            printStudent(student);

        }*/
    }

    @org.junit.Test
    public void testSelectTSBySid() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<TandS> list = studentDao.selectTSBySid(2);
        for (TandS tandS : list) {
            System.out.print(tandS.getSid() + " " + tandS.getSusername() + " " + tandS.getSpassword() + " " + tandS.getSbirthday() + " ");
            System.out.println(tandS.getTid() + " " + tandS.getTusername() + " " + tandS.getTpassword() + " " + tandS.getTbirthday());
        }
    }

    public void printStudent(Student student) {
        System.out.println(student.getId() + " | " + student.getPassword() + " | " + student.getUsername() + " | " + student.getBirthday());
    }
}
