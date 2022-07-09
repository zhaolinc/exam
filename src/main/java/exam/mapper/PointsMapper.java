package exam.mapper;

import exam.domain.Points;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【points】的数据库操作Mapper
* @createDate 2022-05-10 10:47:29
* @Entity exam.domain.Points
*/
@Mapper
public interface PointsMapper{

    List<Points> selectByCourseno(String courseno);

    Integer insert(Points points);
}
