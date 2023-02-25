package org.szx.graduation.dataobject;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class ScenicspotDO {

    private long id;
    private List<PictureDO> urls;
    private String[] urlsr;
    private int[] pageNum;
    private String sname;
    private int rates;//门票价格
    private String city;
    private String sort;
    private String introduce;
    private String ur;
    private List<String> headPortraitDOs;
    private List<String> uname;
    private List<String> content;
    private LocalDateTime gmtCreated;

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<String> getHeadPortraitDOs() {
        return headPortraitDOs;
    }

    public void setHeadPortraitDOs(List<String> headPortraitDOs) {
        this.headPortraitDOs = headPortraitDOs;
    }

    public List<String> getUname() {
        return uname;
    }

    public void setUname(List<String> uname) {
        this.uname = uname;
    }
    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public String[] getUrlsr() {
        return urlsr;
    }

    public void setUrlsr(String[] urlsr) {
        this.urlsr = urlsr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int[] getPageNum() {
        return pageNum;
    }

    public void setPageNum(int[] pageNum) {
        this.pageNum = pageNum;
    }

    public List<PictureDO> getUrls() {
        return urls;
    }

    public void setUrls(List<PictureDO> urls) {
        this.urls = urls;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}
