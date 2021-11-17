package by.tms.dao;

import by.tms.entity.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionnaireDAOImpl implements QuestionnaireDAO{
    private final List<Questionnaire> questionnaires = new ArrayList<>();


    @Override
    public void createQuestionnaire(Questionnaire questionnaire) {
        questionnaires.add(questionnaire);
    }

    @Override
    public Questionnaire getQuestionnaireById(long id) {
        return questionnaires.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    @Override
    public void deleteQuestionnaire(long id) {
        questionnaires.removeIf(p -> p.getId() == id);
    }

    @Override
    public void updateQuestionnaire(Questionnaire questionnaire) {
        questionnaires.set(questionnaires.indexOf(questionnaire), questionnaire);
    }

    @Override
    public boolean isExist(Questionnaire questionnaire) {
        return questionnaires.contains(questionnaire);
    }

    @Override
    public boolean isExistById(long id) {
        return questionnaires.contains(getQuestionnaireById(id));
    }

    @Override
    public List<Questionnaire> getAll() {
        return questionnaires;
    }
}
