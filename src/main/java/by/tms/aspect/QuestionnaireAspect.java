package by.tms.aspect;

import by.tms.entity.Questionnaire;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class QuestionnaireAspect {
    private final Logger logger = LoggerFactory.getLogger(QuestionnaireAspect.class);

    @Pointcut("execution(public * by.tms.controllers.QuestionnaireController.addQuestionnaire(..)) && args(questionnaire)")
    public void addQuestionnaire(Questionnaire questionnaire){}

    @Pointcut("execution(public * by.tms.controllers.QuestionnaireController.updateQuestionnaire(..)) && args(questionnaire)")
    public void updateQuestionnaire(Questionnaire questionnaire){}

    @Pointcut("execution(public * by.tms.controllers.QuestionnaireController.deleteQuestionnaire(..)) && args(id)")
    public void deleteQuestionnaire(long id){}

    @Pointcut("execution(public * by.tms.controllers.QuestionnaireController.getById(..)) && args(id)")
    public void getById(long id){}

    @Pointcut("execution(public * by.tms.controllers.QuestionnaireController.getAll(..))")
    public void getAll(){}

    @After(value = "addQuestionnaire(questionnaire)", argNames = "questionnaire")
    public void add(Questionnaire questionnaire){
        logger.info("Questionnaire with name - {} was added", questionnaire.getName() );
    }

    @After(value = "updateQuestionnaire(questionnaire)", argNames = "questionnaire")
    public void update  (Questionnaire questionnaire){
        logger.info("Questionnaire with name - {} was updated", questionnaire.getName() );
    }

    @After(value = "deleteQuestionnaire(id)", argNames = "id")
    public void delete(long id){
        logger.info("Questionnaire with id - {} was deleted", id );
    }

    @After(value = "getById(id)", argNames = "id")
    public void getId(long id){
        logger.info("Questionnaire with id - {} was received", id );
    }

    @After(value = "getAll()")
    public void getAllQuestionnaires(){
        logger.info("All questionnaires will received");
    }

}
