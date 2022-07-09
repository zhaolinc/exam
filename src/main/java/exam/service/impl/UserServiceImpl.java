package exam.service.impl;

import exam.domain.User;
import exam.mapper.UserMapper;
import exam.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-01 09:37:20
*/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> stuquery(String userno) {
        return this.userMapper.stuquery(userno);
    }

    @Override
    public String getClassno(String userno) {
        return this.userMapper.getClassno(userno);
    }

    @Override
    public List<User> getClassStuList(String classno) {
        return this.userMapper.getClassStuList(classno);
    }

    @Override
    public List<User> getCourseStuList(String courseno) {
        return this.userMapper.getCourseStuList(courseno);
    }

    @Override
    public User queryclassno(String classno) {
        return this.userMapper.queryclassno(classno);
    }

    @Override
    public List<User> getTeachers() {
        return this.userMapper.getTeachers();
    }

    @Override
    public List<User> getAllTeacher() {
        return this.userMapper.getAllTeacher();
    }

    @Override
    public User querylogin(User user) {
        return this.userMapper.querylogin(user);
    }

    @Override
    public List<User> getAllStuT(User user) {
        return this.userMapper.getAllStuT(user);
    }


    @Override
    public List<User> queryAllStudent() {
        return this.userMapper.queryAllStudent();
    }

    @Override
    public Integer updateinfo(User user) {
        return this.userMapper.updateinfo(user);
    }

    @Override
    public Integer update(User user) {
        return this.userMapper.update(user);
    }

    @Override
    public Integer setClassno(String classno, String userno) {
        return this.userMapper.setClassno(classno,userno);
    }

    @Override
    public Integer updatepassword(User user) {
        return this.userMapper.updatepassword(user);
    }

    @Override
    public Integer delete(String userno) {
        return this.userMapper.delete(userno);
    }

    @Override
    public Integer insert(User user) {
        return this.userMapper.insert(user);
    }
}
