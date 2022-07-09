package exam.service.impl;

import exam.domain.Answers;
import exam.mapper.AnswersMapper;
import exam.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【answers】的数据库操作Service实现
* @createDate 2022-05-26 13:44:17
*/
@Service
public class AnswersServiceImpl implements AnswersService{
    @Autowired
    private AnswersMapper answersMapper;

    @Override
    public Integer insert(Answers answers) {
        return this.answersMapper.insert(answers);
    }
}
