package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "class")
public class Clazz implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 专业外键
     */
    @Column(name = "major_id")
    private Integer majorId;

    private static final long serialVersionUID = 1L;

    /**
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取班级名称
     *
     * @return name - 班级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置班级名称
     *
     * @param name 班级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专业外键
     *
     * @return major_id - 专业外键
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * 设置专业外键
     *
     * @param majorId 专业外键
     */
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
}