package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public List<User> getAllUsers();
    User getUser(int id);
    public void update(int id, User updateUser);
    public void delete(int id);
}
