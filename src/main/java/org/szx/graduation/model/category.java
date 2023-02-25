package org.szx.graduation.model;

import org.szx.graduation.dataobject.ScenicspotDO;

import java.util.List;

public class category {
    private String categoryName;

    private List<ScenicspotDO> list;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
