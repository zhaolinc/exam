package exam.mapper;

import exam.domain.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【grade】的数据库操作Mapper
* @createDate 2022-05-26 15:18:22
* @Entity exam.domain.Grade
*/
@Mapper
public interface GradeMapper{

    List<Grade> select(String userno);

    Integer insert(Grade grade);
}
