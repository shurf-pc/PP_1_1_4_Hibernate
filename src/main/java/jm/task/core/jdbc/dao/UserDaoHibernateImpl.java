package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Session session;

    public UserDaoHibernateImpl() {
        try {
            session = Util.getHibernateSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createUsersTable() {
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id int NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age int)").executeUpdate();
        tx.commit();
    }

    @Override
    public void dropUsersTable() {
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
        tx.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.save(user);
        transaction.commit();
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction;
        User user = session.get(User.class, id);
        if (user != null) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } else {
            System.out.println("User not found!");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return session.createQuery("from users", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("truncate table users").executeUpdate();
        tx.commit();
    }
}
