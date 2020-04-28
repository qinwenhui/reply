package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "feedback")
public class Feedback implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 用户外键
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态，0未读，1已读
     */
    private Integer status;

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
     * 获取反馈内容
     *
     * @return content - 反馈内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置反馈内容
     *
     * @param content 反馈内容
     */
    public void setContent(String content) {
        this.content = content;
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
     * 获取状态，0未读，1已读
     *
     * @return status - 状态，0未读，1已读
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0未读，1已读
     *
     * @param status 状态，0未读，1已读
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}