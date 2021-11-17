package by.tms.service;


import by.tms.entity.Questionnaire;
import by.tms.repository.QuestionnaireDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireService {
    private final QuestionnaireDAO questionnaireDAO;

    public QuestionnaireService(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    public boolean createQuestionnaire(Questionnaire questionnaire){
        if (questionnaireDAO.existsQuestionnaireById(questionnaire.getId())){
            return false;
        }else {
            questionnaireDAO.save(questionnaire);
            return true;
        }
    }

    public Optional<Questionnaire> getQuestionnaireById(long id) {
        return questionnaireDAO.findById(id);
    }

    public boolean deleteQuestionnaire(long id){
        if (questionnaireDAO.existsQuestionnaireById(id)){
            questionnaireDAO.deleteById(id);
            return true;
        }else return false;
    }

    public boolean updateQuestionnaire(Questionnaire questionnaire){
        if (questionnaireDAO.existsQuestionnaireById(questionnaire.getId())){
            questionnaireDAO.save(questionnaire);
            return true;
        }else return false;
    }

    public List<Questionnaire> getAll(){
        return questionnaireDAO.findAll();
    }

}
