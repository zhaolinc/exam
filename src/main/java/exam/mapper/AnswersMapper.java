package exam.mapper;

import exam.domain.Answers;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【answers】的数据库操作Mapper
* @createDate 2022-05-26 13:44:17
* @Entity exam.domain.Answers
*/
@Mapper
public interface AnswersMapper{
    Integer insert(Answers answers);

}
