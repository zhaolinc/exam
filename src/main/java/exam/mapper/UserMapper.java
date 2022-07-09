package exam.mapper;

import exam.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-01 09:37:20
* @Entity exam.domain.User
*/
@Mapper
public interface UserMapper{
    List<User> stuquery(String userno);//查询课程学生列表

    String getClassno(String userno);

    List<User> getClassStuList(String classno);//查询班级学生列表

    List<User> getCourseStuList(String courseno);//查询课程学生列表

    User queryclassno(String classno);

    List<User> getTeachers();//获取所有不是班主任的老师

    List<User> getAllTeacher();//查询所有老师

    User querylogin(User user);//登录查询

    List<User> getAllStuT(User user);//查询所有老师

    List<User> queryAllStudent();//查询所有学生

    Integer updateinfo(User user);//修改用户信息

    Integer update(User user);//修改用户信息

    Integer setClassno(String classno,String userno);//设置老师为班主任

    Integer updatepassword(User user);//修改用户密码

    Integer delete(String userno);//删除用户

    Integer insert(User user);//新增用户
}
