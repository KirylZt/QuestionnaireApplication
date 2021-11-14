package by.tms.dao;

import by.tms.entity.Question;

import java.util.List;

public interface QuestionDAO {
    public List<Question> addQuestion(List<Question> questions, Question question);

    public List<Question> deleteQuestion(List<Question> questions, long questionId);

    public List<Question> updateQuestion(List<Question> questions, Question question);
}
