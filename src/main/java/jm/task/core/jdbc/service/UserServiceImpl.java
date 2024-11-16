package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDaoJDBCImpl = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDaoJDBCImpl.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoJDBCImpl.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBCImpl.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoJDBCImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoJDBCImpl.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoJDBCImpl.cleanUsersTable();
    }
}
