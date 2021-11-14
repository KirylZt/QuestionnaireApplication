package by.tms.dao;

import by.tms.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();

    public void createUser(User user);

    public void createWithList(List<User> usersList);

    public List<User> getByUserName(String username);

    public void updateUser(User user);

    public void deleteUser(long id);

    public User getById(long id);

    public boolean isExist(User user);
}
