package exam.mapper;

import exam.domain.Proplem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【proplems】的数据库操作Mapper
* @createDate 2022-05-10 10:47:29
* @Entity exam.domain.Proplems
*/
@Mapper
public interface ProplemMapper {
    List<Proplem> selectAll(Proplem proplem);//查询所有题目

    List<Proplem> selectByType(Integer type,String courseno);

    Proplem selectById(String id);

    Integer insert(Proplem proplem);//新增题目

    Integer update(Proplem proplem);

}
