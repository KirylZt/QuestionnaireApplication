package by.tms.service;

import by.tms.dao.QuestionDAO;
import by.tms.entity.Question;
import by.tms.entity.Questionnaire;
import by.tms.repository.QuestionnaireDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionnaireDAO questionnaireDAO;
    private final QuestionDAO questionDAO;

    public QuestionService(QuestionnaireDAO questionnaireDAO, QuestionDAO questionDAO) {
        this.questionnaireDAO = questionnaireDAO;
        this.questionDAO = questionDAO;
    }

    public boolean addQuestion(long questionnaireId, Question question){
        if (questionnaireDAO.existsQuestionnaireById(questionnaireId)){
           List<Question> questions = questionDAO.addQuestion(questionnaireDAO.getById(questionnaireId).getQuestions(), question);
           Questionnaire questionnaire = questionnaireDAO.getById(questionnaireId);
           questionnaire.setQuestions(questions);
           questionnaireDAO.save(questionnaire);
           return true;
        }else return false;
    }

    public boolean deleteQuestion(long questionnaireId, long questionId){
        if (questionnaireDAO.existsQuestionnaireById(questionnaireId)){
            List<Question> questions = questionDAO.deleteQuestion(questionnaireDAO.getById(questionnaireId).getQuestions(), questionId);
            questionnaireDAO.getById(questionnaireId).setQuestions(questions);
            return true;
        }else return false;
    }

    public boolean updateQuestion(long questionnaireId, Question question){
        if (questionnaireDAO.existsQuestionnaireById(questionnaireId)){
            List<Question> questions = questionDAO.updateQuestion(questionnaireDAO.getById(questionnaireId).getQuestions(), question);
            questionnaireDAO.getById(questionnaireId).setQuestions(questions);
            return true;
        }else return false;
    }
}
