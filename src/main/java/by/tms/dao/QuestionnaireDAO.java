package by.tms.dao;

import by.tms.entity.Question;
import by.tms.entity.Questionnaire;

public interface QuestionnaireDAO {

    public void createQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaireById(long id);

    public void deleteQuestionnaire(long id);

    public void updateQuestionnaire(Questionnaire questionnaire);

    boolean isExist(Questionnaire questionnaire);

    boolean isExistById(long id);
}
