package cn.qinwh.reply.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "appinfo")
public class Appinfo implements Serializable {
    @Id
    @Column(name = "Id")
    private Integer id;

    /**
     * app程序名称
     */
    private String name;

    /**
     * app启动图
     */
    @Column(name = "startup_image")
    private String startupImage;

    /**
     * 下载地址
     */
    private String download;

    /**
     * app版本
     */
    private Float version;

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
     * 获取app程序名称
     *
     * @return name - app程序名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置app程序名称
     *
     * @param name app程序名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取app启动图
     *
     * @return startup_image - app启动图
     */
    public String getStartupImage() {
        return startupImage;
    }

    /**
     * 设置app启动图
     *
     * @param startupImage app启动图
     */
    public void setStartupImage(String startupImage) {
        this.startupImage = startupImage;
    }

    /**
     * 获取下载地址
     *
     * @return download - 下载地址
     */
    public String getDownload() {
        return download;
    }

    /**
     * 设置下载地址
     *
     * @param download 下载地址
     */
    public void setDownload(String download) {
        this.download = download;
    }

    /**
     * 获取app版本
     *
     * @return version - app版本
     */
    public Float getVersion() {
        return version;
    }

    /**
     * 设置app版本
     *
     * @param version app版本
     */
    public void setVersion(Float version) {
        this.version = version;
    }
}