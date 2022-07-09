package exam.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName paper
 */
@Data
@ToString
public class Paper implements Serializable {
    public Paper(){}

    public Paper(String courseno,Double difficulty,String points,Integer type){
        this.courseno = courseno;
        this.difficulty = difficulty;
        this.points = points;
        if (type==1){
            this.single = 5;
            this.singlegrade = 10;
            this.multiple = 5;
            this.multiplegrade = 10;
            this.completion = 0;
            this.completiongrade = 0;
            this.judge = 0;
            this.judgegrade = 0;
            this.simple = 0;
            this.simplegrade = 0;
        }
        if (type==2){
            this.single = 5;
            this.singlegrade = 10;
            this.multiple = 0;
            this.multiplegrade = 0;
            this.completion = 0;
            this.completiongrade = 0;
            this.judge = 5;
            this.judgegrade = 10;
            this.simple = 0;
            this.simplegrade = 0;
        }
        if (type==3){
            this.single = 10;
            this.singlegrade = 10;
            this.multiple = 0;
            this.multiplegrade = 0;
            this.completion = 0;
            this.completiongrade = 0;
            this.judge = 0;
            this.judgegrade = 0;
            this.simple = 0;
            this.simplegrade = 0;
        }
    }
    /**
     * 试卷ID
     */
    private String id;

    /**
     * 所属课程编码
     */
    private String courseno;

    /**
     * 所属课程名称
     */
    private String coursename;

    /**
     * 是否考试
     */
    private Integer type;

    /**
     * 单选题数
     */
    private Integer single;

    /**
     * 单选题分数
     */
    private Integer singlegrade;

    /**
     * 多选题数
     */
    private Integer multiple;

    /**
     * 多选题分数
     */
    private Integer multiplegrade;

    /**
     * 判断题数
     */
    private Integer judge;

    /**
     * 判断题分数
     */
    private Integer judgegrade;

    /**
     * 填空题数
     */
    private Integer completion;

    /**
     * 填空题分数
     */
    private Integer completiongrade;

    /**
     * 简答题数
     */
    private Integer simple;

    /**
     * 简答题分数
     */
    private Integer simplegrade;

    /**
     * 难度系数
     */
    private Double difficulty;

    /**
     * 知识点
     */
    private String points;

    /**
     * 题目列表
     */
    private String problemstr;

    /**
     * 题目列表
     */
    private List<Proplem> problemList;

    /**
     * 总分
     */
    private Integer totalscore;

    /**
     * 考试开始时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starttime;

    /**
     * 考试结束时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;

    /**
     * 出题人
     */
    private String author;

    /**
     * 知识点覆盖率
     */
    private Double coverage;

    /**
     * 适应度
     */
    private Double fitness;

    private static final long serialVersionUID = 1L;

}