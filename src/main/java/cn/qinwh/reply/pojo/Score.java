package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "score")
public class Score implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 评分者外键
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 所属答辩信息外键
     */
    @Column(name = "replyinfo_id")
    private Integer replyinfoId;

    /**
     * 演讲环节得分
     */
    @Column(name = "speech_score")
    private Float speechScore;

    /**
     * 论文写作得分
     */
    @Column(name = "thesis_score")
    private Float thesisScore;

    /**
     * 提问环节得分
     */
    @Column(name = "question_score")
    private Float questionScore;

    /**
     * 总分
     */
    @Column(name = "total_score")
    private Float totalScore;

    /**
     * 批注（评语，备注）
     */
    @Column(name = "`describe`")
    private String describe;

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
     * 获取评分者外键
     *
     * @return user_id - 评分者外键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评分者外键
     *
     * @param userId 评分者外键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取演讲环节得分
     *
     * @return speech_score - 演讲环节得分
     */
    public Float getSpeechScore() {
        return speechScore;
    }

    /**
     * 设置演讲环节得分
     *
     * @param speechScore 演讲环节得分
     */
    public void setSpeechScore(Float speechScore) {
        this.speechScore = speechScore;
    }

    /**
     * 获取论文写作得分
     *
     * @return thesis_score - 论文写作得分
     */
    public Float getThesisScore() {
        return thesisScore;
    }

    /**
     * 设置论文写作得分
     *
     * @param thesisScore 论文写作得分
     */
    public void setThesisScore(Float thesisScore) {
        this.thesisScore = thesisScore;
    }

    /**
     * 获取提问环节得分
     *
     * @return question_score - 提问环节得分
     */
    public Float getQuestionScore() {
        return questionScore;
    }

    /**
     * 设置提问环节得分
     *
     * @param questionScore 提问环节得分
     */
    public void setQuestionScore(Float questionScore) {
        this.questionScore = questionScore;
    }

    /**
     * 获取总分
     *
     * @return total_score - 总分
     */
    public Float getTotalScore() {
        return totalScore;
    }

    /**
     * 设置总分
     *
     * @param totalScore 总分
     */
    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 获取批注（评语，备注）
     *
     * @return describe - 批注（评语，备注）
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置批注（评语，备注）
     *
     * @param describe 批注（评语，备注）
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }
}