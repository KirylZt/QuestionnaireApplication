package by.tms.questionnaireapplicationrest.service;


import by.tms.entity.Question;
import by.tms.entity.Questionnaire;
import by.tms.entity.Variable;
import by.tms.service.QuestionnaireService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class QuestionnaireServiceTest {

    private final QuestionnaireService service;


    @Autowired
    public QuestionnaireServiceTest(QuestionnaireService service) {
        this.service = service;
    }

    @BeforeAll
    public void init(){
        Questionnaire questionnaire1 = Questionnaire.builder().name("History").description("Knowledge questionnaire").key("b").
                questions(List.of(Question.builder().name("Fist ww.").text("First ww started in year?").price(10).
                        variables(List.of(Variable.builder().text("1913").key('a').build(), Variable.builder().text("1914").key('b').build(),
                                Variable.builder().text("1915").key('c').build(), Variable.builder().text("1916").key('d').build()))
                        .answer('b').build())).build();
        Questionnaire questionnaire2 = Questionnaire.builder().name("Math").description("Knowledge questionnaire").key("a").
                questions(List.of(Question.builder().name("Sum").text("2+2*2?").price(10).
                        variables(List.of(Variable.builder().text("6").key('a').build(), Variable.builder().text("8").key('b').build(),
                                Variable.builder().text("10").key('c').build(), Variable.builder().text("no answer").key('d').build()))
                        .answer('b').build())).build();
        service.createQuestionnaire(questionnaire1);
        service.createQuestionnaire(questionnaire2);
    }

    @Test
    @DisplayName("getAll")
    void getAll() {
        assertEquals(2, service.getAll().size());
    }
}
