package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;


public class Util {
    private static final String HOST_NAME = "localhost";
    private static final String DB_NAME = "learningsql";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final SessionFactory sessionFactory;

    static {
        Properties prop = new Properties();
        prop.setProperty(Environment.URL, "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME);
        prop.setProperty(Environment.USER, USER);
        prop.setProperty(Environment.PASS, PASSWORD);
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty(Environment.DRIVER, DRIVER);
        Configuration config = new Configuration();
        config.setProperties(prop);
        config.addAnnotatedClass(User.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static Connection getMySQLConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME, USER, PASSWORD);
    }

    public static Session getHibernateSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}


