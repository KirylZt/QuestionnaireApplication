package by.tms.dao;

import by.tms.entity.Answer;
import by.tms.entity.Questionnaire;

import java.util.List;

public interface AnswerDAO {
    public void addAnswer(Answer answer);
    public void deleteAnswer(long answerId);
    public void updateAnswer(Answer answer);
    List<Answer> getAll();
}
