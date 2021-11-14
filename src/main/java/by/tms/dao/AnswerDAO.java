package by.tms.dao;

import by.tms.entity.Answer;

public interface AnswerDAO {
    public void addAnswer(Answer answer);
    public void deleteAnswer(long answerId);
}
