package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "replygroup")
public class Replygroup implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 答辩组组长
     */
    @Column(name = "leader_id")
    private Integer leaderId;

    /**
     * 答辩组名称
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 答辩地址
     */
    private String address;

    /**
     * 答辩时间
     */
    @Column(name = "reply_time")
    private Date replyTime;

    /**
     * 说明，备注
     */
    private String remarks;

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
     * 获取答辩组组长
     *
     * @return leader_id - 答辩组组长
     */
    public Integer getLeaderId() {
        return leaderId;
    }

    /**
     * 设置答辩组组长
     *
     * @param leaderId 答辩组组长
     */
    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    /**
     * 获取答辩组名称
     *
     * @return name - 答辩组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置答辩组名称
     *
     * @param name 答辩组名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取答辩地址
     *
     * @return address - 答辩地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置答辩地址
     *
     * @param address 答辩地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取答辩时间
     *
     * @return reply_time - 答辩时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 设置答辩时间
     *
     * @param replyTime 答辩时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取说明，备注
     *
     * @return remarks - 说明，备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置说明，备注
     *
     * @param remarks 说明，备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}