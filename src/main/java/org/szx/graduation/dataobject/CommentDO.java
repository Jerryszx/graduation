package org.szx.graduation.dataobject;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentDO {
    private long id;
    private long sid;
    private long uid;
    private String headPortraitDO;
    private String Sname;
    private String Uname;
    private String content;
    private LocalDateTime gmtCreated;

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getHeadPortraitDO() {
        return headPortraitDO;
    }

    public void setHeadPortraitDO(String headPortraitDO) {
        this.headPortraitDO = headPortraitDO;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}
