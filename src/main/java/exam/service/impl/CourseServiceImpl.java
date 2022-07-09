package exam.service.impl;

import exam.domain.Course;
import exam.mapper.CourseMapper;
import exam.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【course】的数据库操作Service实现
* @createDate 2022-05-06 20:10:03
*/
@Service
public class CourseServiceImpl implements CourseService{
    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> select(Course course) {
        return this.courseMapper.select(course);
    }

    @Override
    public List<Course> selectAll() {
        return this.courseMapper.selectAll();
    }

    @Override
    public Course stuquery(String userno) {
        return this.courseMapper.stuquery(userno);
    }

    @Override
    public Course queryno(String courseno) {
        return this.courseMapper.queryno(courseno);
    }

    @Override
    public List<Course> wselect(String userno) {
        return this.courseMapper.wselect(userno);
    }

    @Override
    public Integer insert(Course course) {
        return this.courseMapper.insert(course);
    }

    @Override
    public Integer update(Course course) {
        return this.courseMapper.update(course);
    }

    @Override
    public Integer delete(String courseno) {
        return this.courseMapper.delete(courseno);
    }
}
