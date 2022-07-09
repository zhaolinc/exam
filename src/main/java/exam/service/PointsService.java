package exam.service;

import exam.domain.Points;

import java.util.List;

/**
* @author Administrator
* @description 针对表【points】的数据库操作Service
* @createDate 2022-05-10 10:47:29
*/
public interface PointsService{
    List<Points> selectByCourseno(String courseno);
    Integer insert(Points points);
}
