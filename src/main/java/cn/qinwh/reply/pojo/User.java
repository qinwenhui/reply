package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User implements Serializable {
    @Id
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
     * 真实姓名
     */
    private String name;

    /**
     * 头像
     */
    private String icon;

    /**
     * 班级外键
     */
    @Column(name = "class_id")
    private Integer classId;

    /**
     * 手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色外键
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 状态：0正常，1删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 编号，学生为学号，老师为工号
     */
    private String number;

    /**
     * 类型：0为学生，1为老师
     */
    private Integer type;

    @Transient
    private String token;

    private static final long serialVersionUID = 1L;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return id
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
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取头像
     *
     * @return icon - 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置头像
     *
     * @param icon 头像
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取班级外键
     *
     * @return class_id - 班级外键
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置班级外键
     *
     * @param classId 班级外键
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取手机号
     *
     * @return mobile_phone - 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机号
     *
     * @param mobilePhone 手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 获取状态：0正常，1删除
     *
     * @return status - 状态：0正常，1删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0正常，1删除
     *
     * @param status 状态：0正常，1删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取编号，学生为学号，老师为工号
     *
     * @return number - 编号，学生为学号，老师为工号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置编号，学生为学号，老师为工号
     *
     * @param number 编号，学生为学号，老师为工号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取类型：0为学生，1为老师
     *
     * @return type - 类型：0为学生，1为老师
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0为学生，1为老师
     *
     * @param type 类型：0为学生，1为老师
     */
    public void setType(Integer type) {
        this.type = type;
    }
}