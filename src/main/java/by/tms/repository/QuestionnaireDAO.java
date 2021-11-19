package by.tms.repository;

import by.tms.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireDAO extends JpaRepository<Questionnaire, Long> {
    boolean existsQuestionnaireById(long id);
}
