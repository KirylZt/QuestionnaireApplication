package by.tms.dao;

import by.tms.entity.Question;
import by.tms.entity.Questionnaire;

import java.util.List;

public interface QuestionnaireDAO {

    public void createQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaireById(long id);

    public void deleteQuestionnaire(long id);

    public void updateQuestionnaire(Questionnaire questionnaire);

    boolean isExist(Questionnaire questionnaire);

    boolean isExistById(long id);

    List<Questionnaire> getAll();
}
