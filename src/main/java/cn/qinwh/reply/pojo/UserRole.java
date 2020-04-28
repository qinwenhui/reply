package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_role")
public class UserRole implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 用户外键
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色外键
     */
    @Column(name = "role_id")
    private Integer roleId;

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
     * 获取用户外键
     *
     * @return user_id - 用户外键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户外键
     *
     * @param userId 用户外键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取角色外键
     *
     * @return role_id - 角色外键
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色外键
     *
     * @param roleId 角色外键
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}