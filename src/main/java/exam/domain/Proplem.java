package exam.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName proplems
 */
@Data
@ToString
public class Proplem implements Serializable {
    /**
     * 唯一ID(UUID)
     */
    private String id;

    /**
     * 题型（1、2、3、4、5对应单选，多选，判断，填空，简答）
     */
    @ExcelProperty("题型")
    private Integer type;

    /**
     * 难度系数
     */
    @ExcelProperty("难度系数")
    private Double difficulty;

    /**
     * 知识点
     */
    @ExcelProperty("知识点")
    private String points;

    /**
     * 题目
     */
    @ExcelProperty("题目")
    private String title;

    /**
     * 分数
     */
    @ExcelProperty("分数")
    private Integer score;

    /**
     * 选项A、填空题选项一
     */
    @ExcelProperty("选项A")
    private String selecta;

    /**
     * 选项B、填空题选项二
     */
    @ExcelProperty("选项B")
    private String selectb;

    /**
     * 选项C、填空题选项三
     */
    @ExcelProperty("选项C")
    private String selectc;

    /**
     * 选项D、填空题选项四
     */
    @ExcelProperty("选项D")
    private String selectd;

    /**
     * 简答题答案、判断题答案、填空题答案、选择题答案
     */
    @ExcelProperty("答案")
    private String answer;

    /**
     * 解析
     */
    @ExcelProperty("解析")
    private String anlysis;

    @ExcelProperty("课程编号")
    private String courseno;

    /**
     * 创建时间
     */
    private String createtime;
}