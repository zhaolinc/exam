package exam.controller;

import exam.domain.Answers;
import exam.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswersService answersService;


    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(Answers answers){
        answers.setId(UUID.randomUUID().toString());
        //System.out.println(answers);
        return this.answersService.insert(answers);
    }
}
