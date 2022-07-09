package exam.controller;

import exam.domain.Classes;
import exam.domain.User;
import exam.service.ClasssService;
import exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClasssService classsService;
    @Autowired
    private UserService userService;

    /**
     * 条件查询所有班级
     * @param select
     * @param searchInput
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    List<Classes> select(String select, String searchInput) {
        String classno = "";
        String classname = "";
        if (select!=null && searchInput != null){
            if (select.equals("1"))
                classno = searchInput;
            else classname = searchInput;
        }
        return this.classsService.select(classno,classname);
    }

    @ResponseBody
    @RequestMapping("/classinfo")
    public Classes queryuserno(String userno) {
        String classno = this.userService.getClassno(userno);
        List<User> list = this.userService.getClassStuList(classno);//学生列表
        Classes classes = this.classsService.selectByClassno(classno);
        classes.setStulist(list);
        return classes;

    }

    @ResponseBody
    @RequestMapping("/selectNotFull")
    public List<Classes> selectNotFull() {
        return this.classsService.selectNotFull();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(String classno) {
        return  this.classsService.delete(classno);
    }

    @ResponseBody
    @RequestMapping("/insert")
    Integer insert(@RequestBody Map<String, String> map) {
        if (map!=null){
            Classes classes = new Classes();
            classes.setClassno(map.get("classno"));
            classes.setClassname(map.get("classname"));
            classes.setSize(Integer.valueOf(map.get("size")));
            classes.setAvatar(map.get("avatar"));
            classes.setDescribe(map.get("describe"));
            classes.setTeacherno(map.get("teacherno"));

            if (this.classsService.selectByClassno(classes.getClassno()) !=null){
                return 2; // "班级已经存在!"
            }
            Integer res = this.classsService.insert(classes);
            if (res != 0) {
                return 1; //"添加成功!";
            }
        }

        return 0;
    }

    @ResponseBody
    @RequestMapping("/updateClassInfo")
    public Integer updateClassInfo(@RequestBody Map<String, String> map) {
        Classes classes = new Classes();
        classes.setClassno(map.get("classno"));
        classes.setClassname(map.get("classname"));
        classes.setSize(Integer.valueOf(map.get("size")));
        classes.setAvatar(map.get("avatar"));
        classes.setDescribe(map.get("describe"));
        return this.classsService.updateClassInfo(classes);
    }
}
