package exam.controller;

import exam.domain.Paper;
import exam.domain.Proplem;
import exam.domain.ProplemDB;
import exam.service.PaperService;
import exam.service.ProplemService;
import exam.util.GA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private ProplemService proplemService;

    @ResponseBody
    @RequestMapping("/select")
    public List<Paper> select(Paper paper){
        return this.paperService.select();
    }

    @ResponseBody
    @RequestMapping("/selectById")
    public Paper selectById(String id){
        Paper paper = this.paperService.selectById(id);

        List<Proplem> proplems = new ArrayList<>();
        String str = paper.getProblemstr();
        String[] split = str.split(",");
        for (String s : split) {
            Proplem proplem = this.proplemService.selectById(s);
            proplems.add(proplem);
            //System.out.println(s);
        }
        paper.setProblemList(proplems);
        return paper;
    }

    @ResponseBody
    @RequestMapping("/getTest")
    public List<Paper> getTest(String userno){
        List<Paper> papers = this.paperService.selectTest(userno);
        return papers;
    }


    @ResponseBody
    @RequestMapping("/update")
    public Integer update(String starttime,String endtime,String id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(starttime);
            end = sdf.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Paper paper = new Paper();
        paper.setStarttime(start);
        paper.setEndtime(end);
        paper.setId(id);

        return this.paperService.update(paper);
    }

    @ResponseBody
    @RequestMapping("/cancel")
    public Integer cancel(String id){
        return this.paperService.cancel(id);
    }

    @ResponseBody
    @RequestMapping("/cancelTest")
    public Integer cancelTest(String id){
        return this.paperService.updatenotest(id);
    }

    @ResponseBody
    @RequestMapping("/sendTest")
    public Integer sendTest(String id){
        return this.paperService.updatetest(id);
    }


    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(String id){

        return this.paperService.delete(id);
    }

    @ResponseBody
    @PostMapping("/insert")
    public Integer insert(@RequestBody Map<String, String> map){
        Paper paper = null;
        Paper respaper = null;
        if (map!= null){
            //获取map的值
            String cno = map.get("courseno");//课程编号
            String p = map.get("points");//试卷知识点
            Double d = Double.valueOf(map.get("difficulty"));//难度系数

            Integer type = Integer.valueOf(map.get("typeid"));
            paper = new Paper(cno,d,p,type);
            respaper = new Paper(cno,d,p,type);

            /*全部题目*/
            ProplemDB db = new ProplemDB();
            db.setSingle(this.proplemService.selectByType(1,paper.getCourseno()));
            db.setMultiple(this.proplemService.selectByType(2,paper.getCourseno()));
            db.setJudge(this.proplemService.selectByType(3,paper.getCourseno()));
            db.setCompletion(this.proplemService.selectByType(4,paper.getCourseno()));
            db.setSimple(this.proplemService.selectByType(5,paper.getCourseno()));

            /*初始10套试卷*/
            List<Paper> initPapers = GA.initialize(paper, db);

            /*计算每套试卷的知识点覆盖率*/
            for (int i = 0; i < initPapers.size(); i++) {
                String str = GA.Union(initPapers.get(i));
                initPapers.get(i).setPoints(str);
                double v = GA.kpcCoverage(str,paper.getPoints());//知识点覆盖率
                (initPapers.get(i)).setCoverage(v);//设置知识点覆盖率
            }

            /*计算每套试卷的难度系数*/
            for (int i = 0; i < initPapers.size(); i++) {
                double difficulty = GA.difficulty(initPapers.get(i).getProblemList());
                initPapers.get(i).setDifficulty(difficulty);
            }
            /*计算每套试卷的适应度*/
            for (int i = 0; i < initPapers.size(); i++) {
                double fitness = GA.fitness(initPapers.get(i), paper.getDifficulty());
                initPapers.get(i).setFitness(fitness);
            }

            /*比较返回试卷*/
            int res = 0;
            Double fitness = initPapers.get(0).getFitness();
            for (int i = 0; i < initPapers.size()-1; i++) {
                System.out.println("试卷"+i+": 难度系数:"+initPapers.get(i).getDifficulty()+"  适应度："+initPapers.get(i).getFitness());
                if(initPapers.get(i).getFitness()>fitness){
                    fitness = initPapers.get(i).getFitness();
                    res = i;
                }
            }

            Paper paper1 = initPapers.get(res);
            respaper.setId(UUID.randomUUID().toString());
            respaper.setPoints(paper1.getPoints());
            respaper.setFitness(paper1.getFitness());
            respaper.setDifficulty(paper1.getDifficulty());
            String str = "";
            int a = 1;
            for (Proplem proplem : paper1.getProblemList()) {
                String id = proplem.getId();
                if (a== paper1.getProblemList().size()){
                    str = str + id;
                }else {
                    str = str + id+',';
                }
                a++;
            }

            respaper.setProblemstr(str);

            Integer insert = this.paperService.insert(respaper);

            return insert;
        }

        return 0;
    }
}
