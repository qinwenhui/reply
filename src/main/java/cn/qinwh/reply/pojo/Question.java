package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "question")
public class Question implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 提问者
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 提问所属答辩
     */
    @Column(name = "replyinfo_id")
    private Integer replyinfoId;

    /**
     * 问题音频文件
     */
    @Column(name = "content_file")
    private String contentFile;

    /**
     * 回答内容音频文件
     */
    @Column(name = "reply_content_file")
    private String replyContentFile;

    /**
     * 问题状态，0未回答，1已回答
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 问题描述
     */
    private String content;

    /**
     * 回答内容
     */
    @Column(name = "reply_content")
    private String replyContent;

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
     * 获取提问者
     *
     * @return user_id - 提问者
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置提问者
     *
     * @param userId 提问者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取提问所属答辩
     *
     * @return replyinfo_id - 提问所属答辩
     */
    public Integer getReplyinfoId() {
        return replyinfoId;
    }

    /**
     * 设置提问所属答辩
     *
     * @param replyinfoId 提问所属答辩
     */
    public void setReplyinfoId(Integer replyinfoId) {
        this.replyinfoId = replyinfoId;
    }

    /**
     * 获取问题音频文件
     *
     * @return content_file - 问题音频文件
     */
    public String getContentFile() {
        return contentFile;
    }

    /**
     * 设置问题音频文件
     *
     * @param contentFile 问题音频文件
     */
    public void setContentFile(String contentFile) {
        this.contentFile = contentFile;
    }

    /**
     * 获取回答内容音频文件
     *
     * @return reply_content_file - 回答内容音频文件
     */
    public String getReplyContentFile() {
        return replyContentFile;
    }

    /**
     * 设置回答内容音频文件
     *
     * @param replyContentFile 回答内容音频文件
     */
    public void setReplyContentFile(String replyContentFile) {
        this.replyContentFile = replyContentFile;
    }

    /**
     * 获取问题状态，0未回答，1已回答
     *
     * @return status - 问题状态，0未回答，1已回答
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置问题状态，0未回答，1已回答
     *
     * @param status 问题状态，0未回答，1已回答
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
     * 获取问题描述
     *
     * @return content - 问题描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置问题描述
     *
     * @param content 问题描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取回答内容
     *
     * @return reply_content - 回答内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置回答内容
     *
     * @param replyContent 回答内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}