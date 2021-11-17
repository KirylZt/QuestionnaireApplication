package by.tms.controllers;

import by.tms.entity.Question;
import by.tms.entity.Questionnaire;
import by.tms.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Validated
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addQuest/{questionnaireId}")
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question,@PathVariable long questionnaireId){
        if (questionService.addQuestion(questionnaireId, question)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{questionnaireId}")
    public ResponseEntity<Questionnaire> updateQuestion(@Valid @RequestBody Question question, @PathVariable long questionnaireId){
        if (questionService.updateQuestion(questionnaireId,question)){
            return new ResponseEntity<>(HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/delete/{questionnaireId}/{questionId}")
    public ResponseEntity<Questionnaire> deleteQuestion(@PathVariable long questionnaireId, @PathVariable long questionId){
        if (questionService.deleteQuestion(questionnaireId,questionId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
