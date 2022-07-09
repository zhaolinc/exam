package exam.util;

import exam.domain.Paper;
import exam.domain.Proplem;
import exam.domain.ProplemDB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GA {

    /**
     * 初始化种群
     * @param paper
     * @param db
     * @return
     */
    public static List<Paper> initialize(Paper paper, ProplemDB db){
        List<Paper> init = new ArrayList<>();
        int singleSize = db.getSingle().size();
        int multipleSize = db.getMultiple().size();
        int judgeSize = db.getJudge().size();
        int completionSize = db.getCompletion().size();
        int simpleSize = db.getSimple().size();
        for (int i = 0; i < 20; i++){//根据限定条件生成10套试卷
            List<Proplem> proplems = new ArrayList<>();
            for (int a = 0; a < paper.getSingle(); a++){
                int rand = (int) (Math.random() * (singleSize-1));
                proplems.add(db.getSingle().get(rand));
            }
            for (int a = 0; a < paper.getMultiple(); a++){
                int rand = (int) (Math.random() * (multipleSize-1));
                proplems.add(db.getMultiple().get(rand));
            }
            for (int a = 0; a < paper.getJudge(); a++){
                int rand = (int) (Math.random() * (judgeSize-1));
                proplems.add(db.getJudge().get(rand));
            }
            for (int a = 0; a < paper.getCompletion(); a++){
                int rand = (int) (Math.random() * (completionSize-1));
                proplems.add(db.getCompletion().get(rand));
            }
            for (int a = 0; a < paper.getSimple(); a++){
                int rand = (int) (Math.random() * (simpleSize-1));
                proplems.add(db.getSimple().get(rand));
            }
            Paper paper1 = new Paper();
            paper1.setProblemList(proplems);
            init.add(paper1);
        }
        return init;
    }

    /**
     * 计算知识点覆盖率
     * @return
     */
    public static double kpcCoverage(String str,String points){
        String[] hopesplit = points.split(",");
        int N =0;
        Double M = Double.valueOf(hopesplit.length);

        String[] split = str.split(",");
        for (String s : split) {
            for (String s1 : hopesplit) {
                if (s1.equals(s)){
                    N++;
                }
            }
        }
        double v = N / M;
        return v;
    }

    /**
     * 知识点并集
     * @return
     */
    public static String Union(Paper paper){
        HashSet<String> set = new HashSet<>();//知识点并集
        for (int i = 0; i < paper.getProblemList().size(); i++) {
            Proplem p = paper.getProblemList().get(i);
            String[] split = p.getPoints().split(",");
            for (String s : split) {
                set.add(s);
            }
        }

        String str = "";
        int a = 1;
        for (String s : set) {
            if (a== set.size()){
                str = str + s;
            }else {
                str = str + s+',';
            }
            a++;
        }
        return str;
    }

    /**
     * 计算每套试卷的难度系数
     * @return
     */
    public static double difficulty(List<Proplem> proplems){
        Double molecule = 0.00;
        Integer denominator = 0;
        for (int i = 0; i < proplems.size(); i++) {
            Double v = ((proplems.get(i)).getScore()) * (proplems.get(i).getDifficulty());
            Integer score = proplems.get(i).getScore();
            molecule+=v;
            denominator+=score;
        }
        return molecule/denominator;
    }

    /**
     * 计算每套试卷的适应度
     * @param paper
     * @param hope
     * @return
     */
    public static double fitness(Paper paper,Double hope){
        Double kpccoverage = paper.getCoverage();//知识点覆盖率
        Double difficulty = paper.getDifficulty();//难度系数
        return kpccoverage-(Math.abs(difficulty-hope));
    }


}
