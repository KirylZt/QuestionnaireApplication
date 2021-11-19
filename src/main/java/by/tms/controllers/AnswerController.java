package by.tms.controllers;


import by.tms.entity.Answer;
import by.tms.entity.AnswerConfiguration;
import by.tms.entity.Questionnaire;
import by.tms.service.AnswerService;
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
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Answer> addAnswer(@Valid @RequestBody AnswerConfiguration answerConfiguration){
        if (answerService.addAnswer(answerConfiguration)){
            return new ResponseEntity<>(HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Answer> updateAnswer(@Valid @RequestBody Answer answer, @PathVariable long userId){
        if (answerService.updateAnswer(answer, userId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/delete/{answerId}/{userId}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable long answerId, @PathVariable long userId){
        if (answerService.deleteAnswer(answerId,userId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getById/{id}")
    public ResponseEntity<Answer> getById(@PathVariable long id){
        if (answerService.getAnswerById(id).isPresent()){
            return new ResponseEntity<>(answerService.getAnswerById(id).get(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional(readOnly = true)
    @GetMapping("/getAll")
    public ResponseEntity<List<Answer>> getAll(){
        if(answerService.getAll().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }
}
