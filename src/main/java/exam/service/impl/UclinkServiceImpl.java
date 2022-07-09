package exam.service.impl;

import exam.domain.Uclink;
import exam.mapper.UclinkMapper;
import exam.service.UclinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【sclink】的数据库操作Service实现
* @createDate 2022-05-04 08:38:42
*/
@Service
public class UclinkServiceImpl implements UclinkService {
    @Resource
    private UclinkMapper uclinkMapper;

    @Override
    public String queryno(String userno) {
        return this.uclinkMapper.queryno(userno);
    }

    @Override
    public Uclink query(Uclink uclink) {
        return this.uclinkMapper.query(uclink);
    }

    @Override
    public Integer insert(Uclink uclink) {
        return this.uclinkMapper.insert(uclink);
    }

    @Override
    public Integer update(Uclink uclink) {
        return this.uclinkMapper.update(uclink);
    }

    @Override
    public Integer delete(String courseno) {
        return this.uclinkMapper.delete(courseno);
    }
}
