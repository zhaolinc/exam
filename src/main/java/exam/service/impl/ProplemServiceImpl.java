package exam.service.impl;

import exam.domain.Proplem;
import exam.mapper.ProplemMapper;
import exam.service.ProplemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【proplems】的数据库操作Service实现
* @createDate 2022-05-10 10:47:29
*/
@Service
public class ProplemServiceImpl implements ProplemService {
    @Resource
    private ProplemMapper proplemMapper;

    @Override
    public List<Proplem> selectAll(Proplem proplem) {
        return this.proplemMapper.selectAll(proplem);
    }

    @Override
    public List<Proplem> selectByType(Integer type,String courseno) {
        return this.proplemMapper.selectByType(type,courseno);
    }

    @Override
    public Proplem selectById(String id) {
        return this.proplemMapper.selectById(id);
    }

    @Override
    public Integer insert(Proplem proplem) {
        return this.proplemMapper.insert(proplem);
    }

    @Override
    public Integer update(Proplem proplem) {
        return this.proplemMapper.update(proplem);
    }
}
