package exam.service;

import exam.domain.Grade;

import java.util.List;

/**
* @author Administrator
* @description 针对表【grade】的数据库操作Service
* @createDate 2022-05-26 15:18:23
*/
public interface GradeService {
    List<Grade> select(String userno);
    Integer insert(Grade grade);
}
