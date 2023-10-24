package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void update(int id, User updateUser) {
        User personBeUpdated = getUser(id);

        personBeUpdated.setName(updateUser.getName());
        personBeUpdated.setAge(updateUser.getAge());
        personBeUpdated.setPhoneNumber(updateUser.getPhoneNumber());
        userDao.update(id, personBeUpdated);
    }

    @Transactional
    @Override
    public void delete(int id) {
      userDao.delete(id);
    }
}
