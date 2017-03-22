package novel.model;

import java.util.Date;

public class Book {
    private Integer id;

    private String name;

    private String desc;

    private String img;

    private Date createtime;

    private Date updatetime;

    private String author;

    private String lastpagetitle;

    private Integer lastpageid;

    private Byte status;

    private Byte categoryId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getLastpagetitle() {
        return lastpagetitle;
    }

    public void setLastpagetitle(String lastpagetitle) {
        this.lastpagetitle = lastpagetitle == null ? null : lastpagetitle.trim();
    }

    public Integer getLastpageid() {
        return lastpageid;
    }

    public void setLastpageid(Integer lastpageid) {
        this.lastpageid = lastpageid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
    public Byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
    }
}