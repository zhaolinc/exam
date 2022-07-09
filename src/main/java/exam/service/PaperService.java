package exam.service;

import exam.domain.Paper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【paper】的数据库操作Service
* @createDate 2022-05-16 16:49:21
*/
public interface PaperService{
    List<Paper> select();

    Paper selectById(String id);

    List<Paper> selectTest(String userno);//查询考试

    Integer insert(Paper paper);

    Integer update(Paper paper);

    Integer cancel(String id);

    Integer updatetest(String id);

    Integer updatenotest(String id);

    Integer delete(String id);

}
