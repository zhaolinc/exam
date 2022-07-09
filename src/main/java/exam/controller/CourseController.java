package exam.controller;

import exam.domain.Course;
import exam.domain.Uclink;
import exam.domain.User;
import exam.service.CourseService;
import exam.service.UclinkService;
import exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private UclinkService uclinkService;

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Course> selectAll() {
        return this.courseService.selectAll();
    }

    @ResponseBody
    @RequestMapping("/select")
    public List<Course> select(String select, String searchInput) {
        Course course = new Course();
        if (select != null && searchInput != null){
            if (select.equals("1"))
                course.setCourseno(searchInput);
            else
                course.setCoursename(searchInput);
        }

        return this.courseService.select(course);
    }

    @ResponseBody
    @RequestMapping("/stuquery")
    public Course stuquery(String userno){
        Course course = this.courseService.stuquery(userno);
        List<User> list = this.userService.stuquery(userno);
        course.setUserlist(list);
        return course;
    }

    @ResponseBody
    @RequestMapping("/wselect")
    public List<Course> wselect(String userno){
        List<Course> courses = this.courseService.wselect(userno);
        return courses;
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(@RequestBody Map<String, String> map) {
        Course course = new Course();
        if (map!=null){
            course.setCourseno(map.get("courseno"));
            course.setCoursename(map.get("coursename"));
            course.setSize(Integer.valueOf(map.get("size")));
            course.setAvatar(map.get("avatar"));
            course.setDescribe(map.get("describe"));
        }
        int res = this.courseService.insert(course);
        if (res!=0){
            Uclink uclink = new Uclink();
            uclink.setId(UUID.randomUUID().toString());
            uclink.setUserno(map.get("userno"));
            uclink.setCourseno(map.get("courseno"));
            Integer insert = this.uclinkService.insert(uclink);
            if (insert!=0){
                return 1;
            }

        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Integer update(@RequestBody Map<String, String> map) {
        Course course = new Course();
        Uclink uclink = new Uclink();
        if (map!=null){
            course.setCourseno(map.get("courseno"));
            course.setCoursename(map.get("coursename"));
            course.setSize(Integer.valueOf(map.get("size")));
            course.setAvatar(map.get("avatar"));
            course.setDescribe(map.get("describe"));
        }
        if (map.get("userno")!=null){
            uclink.setCourseno(map.get("courseno"));
            uclink.setUserno(map.get("userno"));
        }
        Integer update = this.courseService.update(course);
        Integer update1 = this.uclinkService.update(uclink);
        if (update!=0 || update1!=0){
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(String courseno) {
        Integer delete = this.courseService.delete(courseno);
        if (delete!=0){
            Integer delete1 = this.uclinkService.delete(courseno);
            if (delete1!=0){
                return 1;
            }
        }
        return 0;
    }
}
