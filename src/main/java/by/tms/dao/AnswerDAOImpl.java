package by.tms.dao;

import by.tms.entity.Answer;
import by.tms.entity.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerDAOImpl implements AnswerDAO{
    private final List<Answer> answers;

    public AnswerDAOImpl(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public void deleteAnswer(long answerId) {
        answers.removeIf(x -> x.getId() == answerId);
    }

    @Override
    public void updateAnswer(Answer answer) {
        answers.set(answers.indexOf(answer),answer);
    }

    @Override
    public List<Answer> getAll() {
        return answers;
    }
}
