package exam.service.impl;

import exam.domain.Grade;
import exam.mapper.GradeMapper;
import exam.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【grade】的数据库操作Service实现
* @createDate 2022-05-26 15:18:22
*/
@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private  GradeMapper gradeMapper;

    @Override
    public List<Grade> select(String userno) {
        return this.gradeMapper.select(userno);
    }

    @Override
    public Integer insert(Grade grade) {

        return this.gradeMapper.insert(grade);
    }
}
