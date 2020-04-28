package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限接口地址
     */
    private String url;

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
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取权限接口地址
     *
     * @return url - 权限接口地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置权限接口地址
     *
     * @param url 权限接口地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}