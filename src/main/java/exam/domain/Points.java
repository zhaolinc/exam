package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName points
 */
@Data
@ToString
public class Points implements Serializable {
    /**
     * UUID
     */
    private String id;

    /**
     * 知识点ID
     */
    private Integer pointid;

    /**
     * 知识点详情
     */
    private String point;

    private String courseno;
}