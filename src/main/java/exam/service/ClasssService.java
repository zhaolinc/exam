package exam.service;

import exam.domain.Classes;

import java.util.List;

/**
* @author Administrator
* @description 针对表【classs】的数据库操作Service
* @createDate 2022-05-05 13:56:54
*/
public interface ClasssService{
    List<Classes> select(String classno,String classname);//查询所有班级
    Classes selectByClassno(String classno);
    List<Classes> selectNotFull();//查询人数未满的班级
    Integer insert(Classes classes);
    Integer delete(String classno);
    Integer updateClassInfo(Classes classes);
}
