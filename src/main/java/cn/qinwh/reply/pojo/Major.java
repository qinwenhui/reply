package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "major")
public class Major implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 学院外键
     */
    @Column(name = "institute_id")
    private Integer instituteId;

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
     * 获取专业名称
     *
     * @return name - 专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     *
     * @param name 专业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学院外键
     *
     * @return institute_id - 学院外键
     */
    public Integer getInstituteId() {
        return instituteId;
    }

    /**
     * 设置学院外键
     *
     * @param instituteId 学院外键
     */
    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }
}