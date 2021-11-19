package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserDAO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user){
        if(!userDao.existsById(user.getId())){
            userDao.save(user);
            return true;
        }else return false ;
    }

    public  void addUsers(List<User> users){
        for (User user: users) {
            if(!userDao.findAll().contains(user)){
                userDao.save(user);
            }
        }
    }

    public Optional<User> getByUsername(String username){
        return userDao.findByUserName(username);
    }

    public boolean updateUser(User user){
        if (userDao.existsById(user.getId())) {
            userDao.save(user);
            return true;
        }else return false;
    }

    public boolean deleteUser(long id){
        if (userDao.existsById(id)){
            userDao.delete(userDao.getById(id));
            return true;
        }else return false;
    }

    public List<User> getAll(){
        return userDao.findAll();
    }
}
