package by.tms.repository;

import by.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User getUserByUserName(String name);
    Optional<User> findByUserName(String userName);
}
