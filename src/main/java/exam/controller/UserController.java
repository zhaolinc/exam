package exam.controller;

import exam.domain.User;
import exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录查询
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public User login(User user){
        User res = this.userService.querylogin(user);
        if (user!=null)
            return res;
        else
            return null;
    }

    /**
     * 查询所有老师学生信息列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllStuT")
    public List<User> getAllStuT(String select, String searchInput,Integer type){
        User user = new User();
        if (select!=null && searchInput != null){
            if (select.equals("1")){
                user.setUserno(searchInput);
            } else {
                user.setName(searchInput);
            }
        }
        if (type!=null){
            user.setType(type);
        }
        return this.userService.getAllStuT(user);
    }

    /**
     * 查询所有不是班主任的老师列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTeachers")
    public List<User> getTeachers() {
        return this.userService.getTeachers();
    }

    @ResponseBody
    @RequestMapping("/getAllTeacher")
    public List<User> getAllTeacher() {
        return this.userService.getAllTeacher();
    }
    /**
     * 查询所有学生信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAllStudent")
    public List<User> queryAllStudent(){
        List<User> list = this.userService.queryAllStudent();
        String master = (this.userService.queryclassno(list.get(0).getClassno())).getMaster();
        for (User user : list) {
            user.setMaster(master);
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/getClassStuList")
    List<User>  getClassStuList(String classno) { //根据classno查询班级全部学生
        return this.userService.getClassStuList(classno);
    }

    @ResponseBody
    @RequestMapping("/getCourseStuList")
    public List<User> getCourseStuList(String courseno) { //根据courseno查询课程全部学生
        return this.userService.getCourseStuList(courseno);
    }
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateinfo")
    public User updateinfo(User user){
        Integer res =  this.userService.updateinfo(user);
        if ( res!= 0){
            return this.userService.querylogin(user);
        }
        else return null;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Integer update(User user) {//小程序更新用户信息
        return this.userService.update(user);
    }

    /**
     * 后台更新用户信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update1")
    public Integer update1(@RequestBody Map<String, String> map) {
        User user = new User();
        if (map != null){
            user.setUserno(map.get("userno"));
            user.setPassword(map.get("password"));
            user.setName(map.get("name"));
            user.setGender(Integer.valueOf(map.get("gender")));
            user.setPhone(map.get("phone"));
            user.setEmail(map.get("email"));
            user.setAvatar(map.get("avatar"));
            user.setClassno(map.get("classno"));
        }
        return this.userService.update(user);
    }

    /**
     * 更新密码
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatepassword")
    public User updatepassword(User user){
        user.setType(0);
        Integer res = this.userService.updatepassword(user);
        if (res != 0){
            User user1 = this.userService.querylogin(user);
            return user1;
        }else
            return null;
    }

    /**
     * 删除用户
     * @param userno
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(String userno) {
        return this.userService.delete(userno);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(@RequestBody Map<String, String> map) {
        User user = new User();
        if (map != null){
            user.setUserno(map.get("userno"));
            user.setPassword("123456");
            user.setName(map.get("name"));
            user.setGender(Integer.valueOf(map.get("gender")));
            user.setPhone(map.get("phone"));
            user.setEmail(map.get("email"));
            user.setAvatar(map.get("avatar"));
            user.setClassno(map.get("classno"));
            user.setType( Integer.valueOf(map.get("type")));
        }
        return this.userService.insert(user);
    }
}
