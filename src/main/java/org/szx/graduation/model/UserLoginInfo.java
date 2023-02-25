package org.szx.graduation.model;

import java.io.Serializable;

public class UserLoginInfo  implements Serializable {

    private String userAccount;

    private String userPwd;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
