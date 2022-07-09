package exam.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName grade
 */
@Data
@ToString
public class Grade implements Serializable {
    /**
     * UUID
     */
    private String id;

    /**
     * 试卷ID
     */
    private String paperid;

    /**
     * 课程ID
     */
    private String courseno;

    /**
     * 课程ID
     */
    private String coursename;

    /**
     * 用户ID
     */
    private String userno;

    /**
     * 总分
     */
    private String totalscore;

    /**
     * 答题时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    private static final long serialVersionUID = 1L;
}