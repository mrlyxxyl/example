package test;

import com.yuexin.bean.*;
import com.yuexin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class BaseTest {
    public static void main(String[] args) {
        add5();
    }


    /**
     * 多对一关系
     */
    public static void add() {
        Teacher teacher = new Teacher();
        teacher.setName("lilaoshi");
        teacher.setId(2);

        Student s1 = new Student();
        s1.setName("xueshengyi");
        s1.setTeacher(teacher);

        Student s2 = new Student();
        s2.setName("xueshenger");
        s2.setTeacher(teacher);

        Session session = null;

        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(teacher);
            session.save(s1);
            session.save(s2);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 一对多关系
     */
    public static void add2() {
        Dept dept = new Dept();
        dept.setName("deptName");
        Set<Emp> emps = new HashSet<Emp>();
        Emp emp1 = new Emp();
        emp1.setName("emp1");
        emps.add(emp1);

        Emp emp2 = new Emp();
        emp2.setName("emp2");
        emps.add(emp2);

        dept.setEmps(emps);

        Session session = null;

        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(dept);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 一对一
     */
    public static void add3() {
        People people = new People();
        people.setName("people");
        IdCard idCard = new IdCard();
        idCard.setName("idcard");
        idCard.setPeople(people);
        people.setIdCard(idCard);
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(people);
            session.save(idCard);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 组件关系
     */
    public static void add4() {
        EnglishPeople people = new EnglishPeople();
        Name name = new Name();
        name.setFirstName("firstName");
        name.setLastName("lastName");
        people.setName(name);
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(people);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    /**
     * 继承关系
     */
    public static void add5() {
        Dept dept = new Dept();
        dept.setName("dept");
        Set<Emp> emps = new HashSet<Emp>();
        Emp emp = new Emp();
        emp.setName("emp");
        emps.add(emp);
        Sales sales = new Sales();
        sales.setName("sale");
        sales.setSale("studey");
        emps.add(sales);
        Skiller skiller = new Skiller();
        skiller.setName("skill");
        skiller.setSkill("skillljflkds");
        emps.add(skiller);
        dept.setEmps(emps);

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(dept);
            session.save(emp);
            session.save(skiller);
            session.save(sales);
            transaction.commit();
        } finally {
            session.close();
        }
    }
}
