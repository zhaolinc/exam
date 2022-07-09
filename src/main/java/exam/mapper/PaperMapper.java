package exam.mapper;

import exam.domain.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【paper】的数据库操作Mapper
* @createDate 2022-05-16 16:49:21
* @Entity exam.domain.Paper
*/
@Mapper
public interface PaperMapper{

    List<Paper> select();

    Paper selectById(String id);

    List<Paper> selectTest(String userno);

    Integer insert(Paper paper);

    Integer update(Paper paper);

    Integer cancel(String id);

    Integer updatetest(String id);

    Integer updatenotest(String id);

    Integer delete(String id);
}
