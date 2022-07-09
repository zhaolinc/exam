package exam.controller;

import exam.domain.Grade;
import exam.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @ResponseBody
    @RequestMapping("/select")
    public List<Grade> select(String userno){
        return this.gradeService.select(userno);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(Grade grade){
        return this.gradeService.insert(grade);

    }
}
