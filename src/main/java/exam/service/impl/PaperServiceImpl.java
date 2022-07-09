package exam.service.impl;

import exam.domain.Paper;
import exam.mapper.PaperMapper;
import exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【paper】的数据库操作Service实现
* @createDate 2022-05-16 16:49:21
*/
@Service
public class PaperServiceImpl implements PaperService{

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<Paper> select() {
        return this.paperMapper.select();
    }

    @Override
    public Paper selectById(String id) {
        return this.paperMapper.selectById(id);
    }

    @Override
    public List<Paper> selectTest(String userno) {
        return this.paperMapper.selectTest(userno);
    }

    @Override
    public Integer insert(Paper paper) {
        return this.paperMapper.insert(paper);
    }

    @Override
    public Integer update(Paper paper) {
        return this.paperMapper.update(paper);
    }

    @Override
    public Integer cancel(String id) {
        return this.paperMapper.cancel(id);
    }

    @Override
    public Integer updatetest(String id) {
        return this.paperMapper.updatetest(id);
    }

    @Override
    public Integer updatenotest(String id) {
        return this.paperMapper.updatenotest(id);
    }

    @Override
    public Integer delete(String id) {
        return this.paperMapper.delete(id);
    }
}
