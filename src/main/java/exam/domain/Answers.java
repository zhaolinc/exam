package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName answers
 */
@Data
@ToString
public class Answers implements Serializable {
    /**
     * UUID
     */
    private String id;

    /**
     * 试卷id
     */
    private String gradeid;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 答案
     */
    private String answer;

    /**
     * 选项分数
     */
    private Integer score;

    private static final long serialVersionUID = 1L;
}