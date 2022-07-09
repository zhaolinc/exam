package exam.service.impl;

import exam.domain.Classes;
import exam.mapper.ClassesMapper;
import exam.service.ClasssService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【classs】的数据库操作Service实现
* @createDate 2022-05-05 13:56:54
*/
@Service
public class ClasssServiceImpl implements ClasssService{
    @Resource
    private ClassesMapper classsMapper;

    @Override
    public List<Classes> select(String classno,String classname) {
        return this.classsMapper.select(classno,classname);
    }

    @Override
    public Classes selectByClassno(String classno) {
        return this.classsMapper.selectByClassno(classno);
    }

    @Override
    public List<Classes> selectNotFull() {
        return this.classsMapper.selectNotFull();
    }

    @Override
    public Integer insert(Classes classes) {
        return this.classsMapper.insert(classes);
    }

    @Override
    public Integer delete(String classno) {
        return this.classsMapper.delete(classno);
    }

    @Override
    public Integer updateClassInfo(Classes classes) {
        return this.classsMapper.updateClassInfo(classes);
    }
}
