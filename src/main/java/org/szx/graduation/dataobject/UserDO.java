package org.szx.graduation.dataobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.szx.graduation.model.User;

import java.time.LocalDateTime;
@Component
public class UserDO {

    private long id;
    private String account;
    private String pwd;
    private String userName;
    private String headPortrait;
    private LocalDateTime gmtCreated;

    public User model(){
        User user=new User();
        user.setId(this.id);
        user.setAccount(this.account);
        if (this.userName==null){
            this.userName="用户"+this.id;
        }
        user.setUserName(this.userName);
        user.setPwd(this.pwd);
        user.setHeadPortrait(this.headPortrait);
        user.setGmtCreated(this.gmtCreated);
        return user;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}
