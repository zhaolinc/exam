package exam.service.impl;

import exam.domain.Points;
import exam.mapper.PointsMapper;
import exam.service.PointsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【points】的数据库操作Service实现
* @createDate 2022-05-10 10:47:29
*/
@Service
public class PointsServiceImpl implements PointsService{

    @Resource
    private PointsMapper pointsMapper;

    @Override
    public List<Points> selectByCourseno(String courseno) {
        return this.pointsMapper.selectByCourseno(courseno);
    }

    @Override
    public Integer insert(Points points) {
        return this.pointsMapper.insert(points);
    }
}
