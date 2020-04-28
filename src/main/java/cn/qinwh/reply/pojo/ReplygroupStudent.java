package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "replygroup_student")
public class ReplygroupStudent implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * 答辩组外键
     */
    @Column(name = "replygroup_id")
    private Integer replygroupId;

    /**
     * 学生外键
     */
    @Column(name = "student_id")
    private Integer studentId;

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
     * 获取学生外键
     *
     * @return student_id - 学生外键
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 设置学生外键
     *
     * @param studentId 学生外键
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}