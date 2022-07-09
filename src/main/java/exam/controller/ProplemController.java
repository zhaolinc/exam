package exam.controller;

import exam.domain.Paper;
import exam.domain.Proplem;
import exam.service.PaperService;
import exam.service.ProplemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/proplem")
public class ProplemController {

    @Autowired
    private ProplemService proplemService;
    @Autowired
    private PaperService paperService;

    @ResponseBody
    @RequestMapping("/list")
    public List<Proplem> list(String id) {
        if(id!=null&&!"".equals(id)){
            List<Proplem> proplems = new ArrayList<>();
            Paper paper = this.paperService.selectById(id);
            String[] split = paper.getProblemstr().split(",");
            for (String s : split) {
                Proplem proplem = this.proplemService.selectById(s);
                proplems.add(proplem);
                //System.out.println(s);
            }
            return proplems;
        }
        return null;
    }



    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Proplem> selectAll(Proplem proplem) {
        return this.proplemService.selectAll(proplem);
    }

    @ResponseBody
    @RequestMapping("/selectAll1")
    public List<Proplem> selectAll(String select,String searchInput) {
        Proplem proplem = new Proplem();

        if (select!=null && (!select.equals(""))){
           proplem.setType( Integer.valueOf(select) );
        }
        if (searchInput != null && (!searchInput.equals(""))){
            proplem.setTitle(searchInput);
        }

        return this.proplemService.selectAll(proplem);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Integer insert(@RequestBody Map<String, String> map) {
        Proplem proplem = new Proplem();
        if (map!=null){
            proplem.setId(UUID.randomUUID().toString());
            proplem.setType(Integer.valueOf(map.get("type")));
            proplem.setDifficulty(Double.valueOf(map.get("difficulty")));
            proplem.setPoints(map.get("points"));
            proplem.setTitle(map.get("title"));
            proplem.setScore(Integer.valueOf(map.get("score")));
            if (proplem.getType()==1 || proplem.getType()==2 || proplem.getType()==4){
                proplem.setSelecta(map.get("selecta"));
                proplem.setSelectb(map.get("selectb"));
                proplem.setSelectc(map.get("selectc"));
                proplem.setSelectd(map.get("selectd"));
            }
            proplem.setAnswer(map.get("answer"));
            proplem.setAnlysis(map.get("anlysis"));
            proplem.setCourseno(map.get("courseno"));
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr=sdf.format(date);
            proplem.setCreatetime(dateStr);
        }
        if (StringUtils.isNotBlank(proplem.getPoints())) {
            String s = proplem.getPoints().replaceAll("\\s*\\[*\\]*\\\"*", "");
            proplem.setPoints(s);
        }

//        String[] split = proplem.getPoints().split(",");
//        for (String s : split) {
//            System.out.println(s);
//        }

        Integer insert = this.proplemService.insert(proplem);
        if (insert!=0){
            return 1;
        }
        return 0;

    }


    @ResponseBody
    @RequestMapping("/update")
    public Integer update(@RequestBody Map<String, String> map) {
        Proplem proplem = new Proplem();
        if (map!=null){
            proplem.setId(map.get("id"));
            proplem.setType(Integer.valueOf(map.get("type")));
            proplem.setDifficulty(Double.valueOf(map.get("difficulty")));
            proplem.setPoints(map.get("points"));
            proplem.setTitle(map.get("title"));
            //proplem.setScore(Integer.valueOf(map.get("score")));
            if (proplem.getType()==1 || proplem.getType()==2){
                proplem.setSelecta(map.get("selecta"));
                proplem.setSelectb(map.get("selectb"));
                proplem.setSelectc(map.get("selectc"));
                proplem.setSelectd(map.get("selectd"));
            }
            proplem.setAnswer(map.get("answer"));
            proplem.setAnlysis(map.get("anlysis"));
        }
        if (StringUtils.isNotBlank(proplem.getPoints())) {
            String s = proplem.getPoints().replaceAll("\\s*\\[*\\]*\\\"*", "");
            proplem.setPoints(s);
        }
        Integer update = this.proplemService.update(proplem);
        //        String[] split = proplem.getPoints().split(",");
        //        for (String s : split) {
        //            System.out.println(s);
        //        }
        if (update!=0){
            return 1;
        }
        return 0;

    }
}
