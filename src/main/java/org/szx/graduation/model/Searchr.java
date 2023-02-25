package org.szx.graduation.model;

import org.szx.graduation.dataobject.ScenicspotDO;
import org.szx.graduation.dataobject.ShoppingCartDO;

import java.util.List;

public class Searchr {

    private List<ScenicspotDO> list1;
    private User user;

    public List<ScenicspotDO> getList1() {
        return list1;
    }

    public void setList1(List<ScenicspotDO> list1) {
        this.list1 = list1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
