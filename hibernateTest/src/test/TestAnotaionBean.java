package test;

import com.yuexin.bean.AnotaionBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TestAnotaionBean {

    public static void main(String[] args) {
        Configuration config = new AnnotationConfiguration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();

        AnotaionBean anotaionBean = new AnotaionBean();
        anotaionBean.setAge(23);
        anotaionBean.setName("nanmeiying");
        anotaionBean.setBirth(new Date());

        Session session = null;
        Transaction transaction;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(anotaionBean);
            transaction.commit();
        } catch (HibernateException e) {
            session.close();
        }
    }
}
