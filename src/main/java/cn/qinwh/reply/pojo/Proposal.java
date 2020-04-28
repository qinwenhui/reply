package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "proposal")
public class Proposal implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 提出者
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 所属答辩信息外键
     */
    @Column(name = "replyinfo_id")
    private Integer replyinfoId;

    /**
     * 状态，0未采纳，1已采纳
     */
    private Integer status;

    /**
     * 答辩建议内容
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
     * 获取提出者
     *
     * @return user_id - 提出者
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置提出者
     *
     * @param userId 提出者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取所属答辩信息外键
     *
     * @return replyinfo_id - 所属答辩信息外键
     */
    public Integer getReplyinfoId() {
        return replyinfoId;
    }

    /**
     * 设置所属答辩信息外键
     *
     * @param replyinfoId 所属答辩信息外键
     */
    public void setReplyinfoId(Integer replyinfoId) {
        this.replyinfoId = replyinfoId;
    }

    /**
     * 获取状态，0未采纳，1已采纳
     *
     * @return status - 状态，0未采纳，1已采纳
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0未采纳，1已采纳
     *
     * @param status 状态，0未采纳，1已采纳
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取答辩建议内容
     *
     * @return content - 答辩建议内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置答辩建议内容
     *
     * @param content 答辩建议内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}