package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("John", "Doe", (byte) 23);
        userService.saveUser("Jane", "Chong", (byte) -66);
        userService.saveUser("Jack", "Lee", (byte) 12);
        userService.saveUser("Haval", "Jolion", (byte) 1);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
