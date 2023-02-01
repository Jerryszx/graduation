package org.szx.graduation.model;

import java.time.LocalDateTime;
import java.util.List;

public class scenicspot {
    private long id;
    private String url;
    private List<String> sname;
    private int rates;//门票价格
    private String city;
    private String introduce;
    private LocalDateTime gmtCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getSname() {
        return sname;
    }

    public void setSname(List<String> sname) {
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
