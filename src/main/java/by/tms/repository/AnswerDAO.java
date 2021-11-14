package by.tms.repository;

import by.tms.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDAO extends JpaRepository<Answer,Long> {
    boolean existsAnswerById(long id);
}
