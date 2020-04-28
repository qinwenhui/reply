package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "role_permission")
public class RolePermission implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 角色外键
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限外键
     */
    @Column(name = "permission_id")
    private Integer permissionId;

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

    /**
     * 获取权限外键
     *
     * @return permission_id - 权限外键
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限外键
     *
     * @param permissionId 权限外键
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}