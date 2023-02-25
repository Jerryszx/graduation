package org.szx.graduation.model;

import org.szx.graduation.dataobject.ScenicspotDO;

import java.util.List;

public class city {
    private String cityName;

    private List<ScenicspotDO> list;

    public List<ScenicspotDO> getList() {
        return list;
    }

    public void setList(List<ScenicspotDO> list) {
        this.list = list;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
