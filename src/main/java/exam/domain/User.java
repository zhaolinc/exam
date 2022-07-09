package exam.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    private String userno;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(1：男    0：女)
     */
    private Integer gender;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;


    /**
     * 班级编号
     */
    private String classno;

    /**
     * 类型(0：学生  1：老师   2：管理员 )
     */
    private Integer type;

    /**
     * 班级名称
     */
    private String classname;

    /**
     * 班主任
     */
    private String master;


}