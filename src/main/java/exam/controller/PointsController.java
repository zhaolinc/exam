package exam.controller;

import exam.domain.Points;
import exam.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/points")
public class PointsController {
    @Autowired
    private PointsService pointsService;


    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(Points point){
        if(point.getPoint()!=null&point.getPointid()!=null&point.getCourseno()!=null){
            point.setId(UUID.randomUUID().toString());
            return this.pointsService.insert(point);
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/selectByCourseno")
    public List<Points> selectByCourseno(String courseno) {
        return this.pointsService.selectByCourseno(courseno);
    }


}
