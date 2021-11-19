package by.tms.service;

import by.tms.entity.Answer;
import by.tms.entity.AnswerConfiguration;
import by.tms.entity.Role;
import by.tms.entity.Status;
import by.tms.repository.AnswerDAO;
import by.tms.repository.QuestionnaireDAO;
import by.tms.repository.UserDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class AnswerService {
    private final AnswerDAO answerDAO;
    private final QuestionnaireDAO questionnaireDAO;
    private final UserDAO userDAO;


    public AnswerService(AnswerDAO answerDAO, QuestionnaireDAO questionnaireDAO, UserDAO userDAO) {
        this.answerDAO = answerDAO;
        this.questionnaireDAO = questionnaireDAO;
        this.userDAO = userDAO;
    }

    public boolean addAnswer(AnswerConfiguration answerConfiguration){
        if (userDAO.existsById(answerConfiguration.getUserId()) && questionnaireDAO.existsQuestionnaireById(answerConfiguration.getQuestionnaireId())){
            answerDAO.save(new Answer(
                    answerConfiguration.getId(),
                    questionnaireDAO.getById(answerConfiguration.getQuestionnaireId()),
                    userDAO.getById(answerConfiguration.getUserId()),
                    answerConfiguration.getQuestionAnswer(),
                    LocalDate.now()
            ));
            return true;
        }else return false;
    }

    public boolean deleteAnswer(long answerId, long userId){
        if (answerDAO.existsAnswerById(answerId) && userDAO.existsById(userId)){
            if (userDAO.getById(userId).getRoles().contains(new Role(0,Status.ROLE_ADMIN))){
                answerDAO.deleteById(answerId);
                return true;
            }else return false;
        }else return false;
    }

    public boolean updateAnswer(Answer answer, long userId){
        if (answerDAO.existsAnswerById(answer.getId()) && userDAO.existsById(userId)){
            if (userDAO.getById(userId).getRoles().contains(new Role(0,Status.ROLE_ADMIN))) {
                answerDAO.save(answer);
                return true;
            }else return false;
        }else return false;
    }

    public Optional<Answer> getAnswerById(long answerId){
        return answerDAO.findById(answerId);
    }

    public List<Answer> getAll(){
        return answerDAO.findAll();
    }
}
