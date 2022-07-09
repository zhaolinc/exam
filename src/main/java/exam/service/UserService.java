package exam.service;

import exam.domain.User;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-01 09:37:20
*/
public interface UserService{
    List<User> stuquery(String userno);
    String getClassno(String userno);
    List<User> getClassStuList(String classno);
    List<User> getCourseStuList(String courseno);//查询课程学生列表
    User queryclassno(String classno);
    List<User> getTeachers();
    List<User> getAllTeacher();//查询所有老师
    User querylogin(User user);//登录
    List<User> getAllStuT(User user);//查询所有老师
    List<User> queryAllStudent();//查询所有学生
    Integer updateinfo(User user);
    Integer update(User user);//修改用户信息
    Integer setClassno(String classno,String userno);
    Integer updatepassword(User user);//修改密码
    Integer delete(String userno);//删除用户
    Integer insert(User user);//新增用户
}
