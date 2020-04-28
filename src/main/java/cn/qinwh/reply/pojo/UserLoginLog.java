package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_login_log")
public class UserLoginLog implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 登录时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登录ip
     */
    private String ip;

    /**
     * 登录设备
     */
    private String device;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取登录时间
     *
     * @return create_time - 登录时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置登录时间
     *
     * @param createTime 登录时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    /**
     * 获取登录设备
     *
     * @return device - 登录设备
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置登录设备
     *
     * @param device 登录设备
     */
    public void setDevice(String device) {
        this.device = device;
    }
}