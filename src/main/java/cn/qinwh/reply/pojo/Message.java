package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "message")
public class Message implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 发送者外键
     */
    @Column(name = "sender_id")
    private Integer senderId;

    /**
     * 接收者外键
     */
    @Column(name = "receiver_id")
    private Integer receiverId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态，0未读，1已读
     */
    private Integer status;

    /**
     * 内容
     */
    private String content;

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
     * 获取发送者外键
     *
     * @return sender_id - 发送者外键
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * 设置发送者外键
     *
     * @param senderId 发送者外键
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    /**
     * 获取接收者外键
     *
     * @return receiver_id - 接收者外键
     */
    public Integer getReceiverId() {
        return receiverId;
    }

    /**
     * 设置接收者外键
     *
     * @param receiverId 接收者外键
     */
    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
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

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}