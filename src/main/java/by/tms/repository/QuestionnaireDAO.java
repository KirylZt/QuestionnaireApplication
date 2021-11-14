package by.tms.repository;

import by.tms.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireDAO extends JpaRepository<Questionnaire, Long> {
    boolean existsQuestionnaireById(long id);
}
