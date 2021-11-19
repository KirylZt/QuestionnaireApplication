package by.tms.repository;

import by.tms.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDAO extends JpaRepository<Answer,Long> {
    boolean existsAnswerById(long id);
    @Override
    List<Answer> findAll();
}

