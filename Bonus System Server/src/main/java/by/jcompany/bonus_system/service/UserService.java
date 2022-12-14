package by.jcompany.bonus_system.service;

import by.jcompany.bonus_system.dao.UserDao;
import by.jcompany.bonus_system.entity.User;

import java.util.List;

public class UserService implements Service<User, Integer> {
    UserDao userDao = new UserDao();
    
    @Override
    public boolean create(User user) {
        return userDao.create(user);
    }
    
    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }
    
    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }
    
    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }
    
    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }
    
    public User read(String login) {
        return userDao.read(login);
    }
}
