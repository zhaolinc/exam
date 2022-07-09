package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName classs
 */
@ToString
@Data
public class Classes implements Serializable {
    /**
     * 班级no
     */
    private String classno;

    /**
     * 班级名
     */
    private String classname;

    /**
     * 班级人数
     */
    private Integer count;

    /**
     * 班级最大人数
     */
    private Integer size;

    /**
     * 班级头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String describe;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 老师编号
     */
    private String teacherno;

    /**
     * 班主任
     */
    private String master;

    /**
     * 学生列表
     */
    private List<User> stulist;
}