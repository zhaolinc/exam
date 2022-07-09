package exam.controller;

import exam.domain.Course;
import exam.domain.Uclink;
import exam.service.CourseService;
import exam.service.UclinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/sclink")
public class UclinkController {
    @Autowired
    private UclinkService uclinkService;
    @Autowired
    private CourseService courseService;

    @ResponseBody
    @RequestMapping("/insert")
    public String insert(Uclink uclink){
        Uclink uclink1 = this.uclinkService.query(uclink);
        if(uclink1 ==null){//判断是否已经加入班级
            String id = UUID.randomUUID().toString();
            uclink.setId(id);
            Course course = this.courseService.queryno(uclink.getCourseno());

            if (course != null){//判断是否存在课程
                Integer res = this.uclinkService.insert(uclink);
                if (res!=0){
                    return "success";
                }else {
                    return "fail";
                }
            }else
                return "error";
        }else {
            return "";
        }
    }
}
