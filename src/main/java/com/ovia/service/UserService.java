package com.ovia.service;

import com.ovia.dao.UserDao;
import com.ovia.model.user.User;
import com.ovia.model.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Autowired
    private UserDao userDao;

    /**
     *
     * @return
     */
    public Users getAllUsers() {
        Users response = new Users();
        List<User> list = new ArrayList<>();
        userDao.findAll().forEach(user -> list.add(user));
        response.setUserList(list);
        return response;
    }

    /**
     *
     * @param name
     * @return
     */
    public User getUserById(String name) {
        return userDao.findById(name).get();
    }

    /**
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        return userDao.save(user);
    }

    /**
     *
     * @param name
     */
    public void delete(String name) {
        userDao.deleteById(name);
    }
}
