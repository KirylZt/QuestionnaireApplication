package by.tms.repository;

import by.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    List<User> getUsersByUserName(String userName);
}
