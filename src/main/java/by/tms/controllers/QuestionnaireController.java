package by.tms.controllers;


import by.tms.entity.Questionnaire;
import by.tms.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;


    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/addQuest")
    public ResponseEntity<Questionnaire> addQuestionnaire(@Valid @RequestBody Questionnaire questionnaire){
        if (questionnaireService.createQuestionnaire(questionnaire)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@Valid @RequestBody Questionnaire questionnaire){
        if (questionnaireService.updateQuestionnaire(questionnaire)){
            return new ResponseEntity<>(HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<Questionnaire> deleteQuestionnaire(@PathVariable long id){
        if (questionnaireService.deleteQuestionnaire(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getById/{id}")
    public ResponseEntity<Questionnaire> getById(@PathVariable long id){
        if (questionnaireService.getQuestionnaireById(id).isPresent()){
            return new ResponseEntity<>(questionnaireService.getQuestionnaireById(id).get(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getAll")
    public ResponseEntity<List<Questionnaire>> getAll(){
        if(!questionnaireService.getAll().isEmpty()){
            return new ResponseEntity<>(questionnaireService.getAll(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
