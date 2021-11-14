package by.tms.service;

import by.tms.entity.Answer;
import by.tms.repository.AnswerDAO;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;


    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public boolean addAnswer(Answer answer){
        if (!answerDAO.existsAnswerById(answer.getId())){
            answerDAO.save(answer);
            return true;
        }else return false;
    }

    public boolean deleteAnswer(long answerId){
        if (answerDAO.existsAnswerById(answerId)){
            answerDAO.deleteById(answerId);
            return true;
        }else return false;
    }
}
