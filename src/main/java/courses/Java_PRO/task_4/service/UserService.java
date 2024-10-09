package courses.Java_PRO.task_4.service;

import courses.Java_PRO.task_4.User;
import courses.Java_PRO.task_4.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(String username) {
        return userDao.createUser(username);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
