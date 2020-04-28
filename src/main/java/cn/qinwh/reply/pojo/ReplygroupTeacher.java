package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "replygroup_teacher")
public class ReplygroupTeacher implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 答辩组外键
     */
    @Column(name = "replygroup_id")
    private Integer replygroupId;

    /**
     * 老师外键
     */
    @Column(name = "teacher_id")
    private Integer teacherId;

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
     * 获取答辩组外键
     *
     * @return replygroup_id - 答辩组外键
     */
    public Integer getReplygroupId() {
        return replygroupId;
    }

    /**
     * 设置答辩组外键
     *
     * @param replygroupId 答辩组外键
     */
    public void setReplygroupId(Integer replygroupId) {
        this.replygroupId = replygroupId;
    }

    /**
     * 获取老师外键
     *
     * @return teacher_id - 老师外键
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置老师外键
     *
     * @param teacherId 老师外键
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}