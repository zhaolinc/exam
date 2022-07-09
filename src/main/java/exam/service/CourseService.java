package exam.service;

import exam.domain.Course;

import java.util.List;

/**
* @author Administrator
* @description 针对表【course】的数据库操作Service
* @createDate 2022-05-06 20:10:03
*/
public interface CourseService{
    List<Course> select(Course course);
    List<Course> selectAll();
    Course stuquery(String userno);
    Course queryno(String courseno);
    List<Course> wselect(String userno);
    Integer insert(Course course);
    Integer update(Course course);
    Integer delete(String courseno);
}
