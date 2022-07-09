package exam.service;

import exam.domain.Answers;

/**
* @author Administrator
* @description 针对表【answers】的数据库操作Service
* @createDate 2022-05-26 13:44:17
*/
public interface AnswersService{
    Integer insert(Answers answers);
}
