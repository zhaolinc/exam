package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName course
 */
@Data
@ToString
public class Course implements Serializable {
    /**
     * 课程no
     */
    private String courseno;

    /**
     * 课程名称
     */
    private String coursename;

    /**
     * 课程现在人数
     */
    private Integer count;

    /**
     * 课程人数容量
     */
    private Integer size;

    /**
     * 课程图片
     */
    private String avatar;

    /**
     * 课程描述
     */
    private String describe;

    /**
     *  创建时间
     */
    private String createtime;

    /**
     *  老师学生列表
     */
    private List<User> userlist;

    /**
     *  老师名字
     */
    private String teachername;

}