package by.tms.repository;

import by.tms.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerDAO extends JpaRepository<Answer,Long> {
    boolean existsAnswerById(long id);

    @Override
    List<Answer> findAll();


}

