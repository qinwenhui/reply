package cn.qinwh.reply.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "replyinfo")
public class Replyinfo implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 答辩时间
     */
    @Column(name = "reply_time")
    private Date replyTime;

    /**
     * 学生id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 答辩分数
     */
    private Float score;

    /**
     * 状态，0未开始，1正在进行，2已结束
     */
    private Integer status;

    /**
     * 描述（比如属于什么类型的答辩，第一次答辩还是第二次）
     */
    @Column(name = "`describe`")
    private String describe;

    /**
     * 答辩标题
     */
    private String title;

    /**
     * ppt文件地址
     */
    private String ppt;

    /**
     * 论文地址
     */
    private String thesis;

    /**
     * 其他附件地址
     */
    @Column(name = "other_file")
    private String otherFile;

    /**
     * 组内答辩顺序
     */
    private Integer sort;

    /**
     * 演讲环节音频文件
     */
    private String speech;

    /**
     * 提问环节外键
     */
    @Column(name = "question_id")
    private Integer questionId;

    /**
     * 评分环节外键
     */
    @Column(name = "score_id")
    private Integer scoreId;

    /**
     * 成绩公布状态,0未公布，1已公布
     */
    @Column(name = "score_status")
    private Integer scoreStatus;

    /**
     * 演讲环节状态，0未开始，1正在进行，2已结束
     */
    @Column(name = "speech_status")
    private Integer speechStatus;

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
     * 获取学生id
     *
     * @return user_id - 学生id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置学生id
     *
     * @param userId 学生id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取答辩分数
     *
     * @return score - 答辩分数
     */
    public Float getScore() {
        return score;
    }

    /**
     * 设置答辩分数
     *
     * @param score 答辩分数
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 获取状态，0未开始，1正在进行，2已结束
     *
     * @return status - 状态，0未开始，1正在进行，2已结束
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0未开始，1正在进行，2已结束
     *
     * @param status 状态，0未开始，1正在进行，2已结束
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取描述（比如属于什么类型的答辩，第一次答辩还是第二次）
     *
     * @return describe - 描述（比如属于什么类型的答辩，第一次答辩还是第二次）
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置描述（比如属于什么类型的答辩，第一次答辩还是第二次）
     *
     * @param describe 描述（比如属于什么类型的答辩，第一次答辩还是第二次）
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取答辩标题
     *
     * @return title - 答辩标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置答辩标题
     *
     * @param title 答辩标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取ppt文件地址
     *
     * @return ppt - ppt文件地址
     */
    public String getPpt() {
        return ppt;
    }

    /**
     * 设置ppt文件地址
     *
     * @param ppt ppt文件地址
     */
    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    /**
     * 获取论文地址
     *
     * @return thesis - 论文地址
     */
    public String getThesis() {
        return thesis;
    }

    /**
     * 设置论文地址
     *
     * @param thesis 论文地址
     */
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    /**
     * 获取其他附件地址
     *
     * @return other_file - 其他附件地址
     */
    public String getOtherFile() {
        return otherFile;
    }

    /**
     * 设置其他附件地址
     *
     * @param otherFile 其他附件地址
     */
    public void setOtherFile(String otherFile) {
        this.otherFile = otherFile;
    }

    /**
     * 获取组内答辩顺序
     *
     * @return sort - 组内答辩顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置组内答辩顺序
     *
     * @param sort 组内答辩顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取演讲环节音频文件
     *
     * @return speech - 演讲环节音频文件
     */
    public String getSpeech() {
        return speech;
    }

    /**
     * 设置演讲环节音频文件
     *
     * @param speech 演讲环节音频文件
     */
    public void setSpeech(String speech) {
        this.speech = speech;
    }

    /**
     * 获取提问环节外键
     *
     * @return question_id - 提问环节外键
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 设置提问环节外键
     *
     * @param questionId 提问环节外键
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取评分环节外键
     *
     * @return score_id - 评分环节外键
     */
    public Integer getScoreId() {
        return scoreId;
    }

    /**
     * 设置评分环节外键
     *
     * @param scoreId 评分环节外键
     */
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    /**
     * 获取成绩公布状态,0未公布，1已公布
     *
     * @return score_status - 成绩公布状态,0未公布，1已公布
     */
    public Integer getScoreStatus() {
        return scoreStatus;
    }

    /**
     * 设置成绩公布状态,0未公布，1已公布
     *
     * @param scoreStatus 成绩公布状态,0未公布，1已公布
     */
    public void setScoreStatus(Integer scoreStatus) {
        this.scoreStatus = scoreStatus;
    }

    /**
     * 获取演讲环节状态，0未开始，1正在进行，2已结束
     *
     * @return speech_status - 演讲环节状态，0未开始，1正在进行，2已结束
     */
    public Integer getSpeechStatus() {
        return speechStatus;
    }

    /**
     * 设置演讲环节状态，0未开始，1正在进行，2已结束
     *
     * @param speechStatus 演讲环节状态，0未开始，1正在进行，2已结束
     */
    public void setSpeechStatus(Integer speechStatus) {
        this.speechStatus = speechStatus;
    }
}