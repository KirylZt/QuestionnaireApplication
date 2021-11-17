package by.tms.controllers;


import by.tms.entity.Answer;
import by.tms.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Validated
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;


    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

//    @GetMapping("/save/{userId}/{questionnaireId}/{key}")
//    public ResponseEntity<Answer> addAnswer(@PathVariable long userId, @PathVariable long questionnaireId, @PathVariable String key){
//        if (answerService.addAnswer(userId,questionnaireId,key)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

}
