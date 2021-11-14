package by.tms.dao;

import by.tms.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDAOImpl implements QuestionDAO{

    @Override
    public List<Question> addQuestion(List<Question> questions, Question question) {
        questions.add(question);
        return questions;
    }

    @Override
    public List<Question> deleteQuestion(List<Question> questions, long questionId) {
        questions.removeIf(x -> x.getId() == questionId);
        return questions;
    }

    @Override
    public List<Question> updateQuestion(List<Question> questions, Question question) {
        questions.set(questions.indexOf(question), question);
        return questions;
    }
}
