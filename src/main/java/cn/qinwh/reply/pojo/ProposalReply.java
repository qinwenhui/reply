package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "proposal_reply")
public class ProposalReply implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 所属建议外键
     */
    @Column(name = "proposal_id")
    private Integer proposalId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 回复者
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 回复内容
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
     * 获取所属建议外键
     *
     * @return proposal_id - 所属建议外键
     */
    public Integer getProposalId() {
        return proposalId;
    }

    /**
     * 设置所属建议外键
     *
     * @param proposalId 所属建议外键
     */
    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
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
     * 获取回复者
     *
     * @return user_id - 回复者
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置回复者
     *
     * @param userId 回复者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取回复内容
     *
     * @return content - 回复内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置回复内容
     *
     * @param content 回复内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}