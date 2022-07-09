package exam.service;

import exam.domain.Proplem;

import java.util.List;

/**
* @author Administrator
* @description 针对表【proplems】的数据库操作Service
* @createDate 2022-05-10 10:47:29
*/
public interface ProplemService {
    List<Proplem> selectAll(Proplem proplem);//查询所有题目

    List<Proplem> selectByType(Integer type,String courseno);

    Proplem selectById(String id);

    Integer insert(Proplem proplem);//新增题目

    Integer update(Proplem proplem);
}
