package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色表外键
     */
    private Integer role_id;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 状态，0正常，1异常
     */
    private Integer status;

    /**
     * 登录ip
     */
    private String ip;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取角色表外键
     *
     * @return role_id - 角色表外键
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置角色表外键
     *
     * @param role_id 角色表外键
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置创建时间
     *
     * @param create_time 创建时间
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 设置更新时间
     *
     * @param update_time 更新时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * 获取状态，0正常，1异常
     *
     * @return status - 状态，0正常，1异常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0正常，1异常
     *
     * @param status 状态，0正常，1异常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取登录ip
     *
     * @return ip - 登录ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置登录ip
     *
     * @param ip 登录ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}