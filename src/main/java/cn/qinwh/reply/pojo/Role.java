package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "role")
public class Role implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }
}