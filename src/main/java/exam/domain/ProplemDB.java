package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ProplemDB {
    /**
     * 单选题
     */
    private List<Proplem> single;

    /**
     * 多选题
     */
    private List<Proplem> multiple;

    /**
     * 判断题
     */
    private List<Proplem> judge;

    /**
     * 填空题
     */
    private List<Proplem> completion;

    /**
     * 简答题
     */
    private List<Proplem> simple;
    
}
