package novel.model;

import java.util.Date;

public class CrawelBook {
    private int id;

    private String bookName;

    private String bookLink;

    private Date insertTime;

    private byte status;

    private String lastArticleLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getLastArticleLink() {
        return lastArticleLink;
    }

    public void setLastArticleLink(String lastArticleLink) {
        this.lastArticleLink = lastArticleLink;
    }
}