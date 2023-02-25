package org.szx.graduation.model;

import org.hibernate.validator.constraints.Length;
import org.szx.graduation.dataobject.ScenicspotDO;
import org.szx.graduation.dataobject.ShoppingCartDO;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

public class User {
    private long id;
    @NotEmpty(message = "账号不能为空")
    @Length(message = "账号长度6-10位",min = 6,max = 10)
    private String account;
    @NotEmpty(message = "密码不能为空")
    @Length(message = "密码长度6-10位",min = 6,max = 10)
    private String pwd;
    private String confirmPwd;
    private String userName;
    private String headPortrait;
    private LocalDateTime gmtCreated;

    private List<String> shoppicture;
    private List<String> shopname;

    private List<Integer> shoprates;

    public List<Integer> getShoprates() {
        return shoprates;
    }

    public void setShoprates(List<Integer> shoprates) {
        this.shoprates = shoprates;
    }

    private List<String> url;
    private String ur;
    private List<ScenicspotDO> sc;

    private ScenicspotDO scr;

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getShoppicture() {
        return shoppicture;
    }

    public void setShoppicture(List<String> shoppicture) {
        this.shoppicture = shoppicture;
    }

    public List<String> getShopname() {
        return shopname;
    }

    public void setShopname(List<String> shopname) {
        this.shopname = shopname;
    }

    public ScenicspotDO getScr() {
        return scr;
    }

    public void setScr(ScenicspotDO scr) {
        this.scr = scr;
    }

    public List<ScenicspotDO> getSc() {
        return sc;
    }

    public void setSc(List<ScenicspotDO> sc) {
        this.sc = sc;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


}
