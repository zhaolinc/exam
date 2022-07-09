package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
/**
 * 
 * @TableName sclink
 */
@ToString
@Data
public class Uclink implements Serializable {
    /**
     * UUID
     */
    private String id;

    /**
     * 学生no
     */
    private String userno;

    /**
     * courseno
     */
    private String courseno;
}