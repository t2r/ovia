package com.ovia.model.user;

import com.ovia.model.JsonModelObject;

import java.util.ArrayList;
import java.util.List;

public class Users extends JsonModelObject {
    private List<User> userList;

    public List<User> getUserList() {
        if(userList == null) {
            userList = new ArrayList<>();
        }
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
