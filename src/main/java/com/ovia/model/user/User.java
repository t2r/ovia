package com.ovia.model.user;

import com.ovia.model.JsonModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends JsonModelObject {

    public User() {}

    public User(String name) {
        super();
        this.name = name;
    }

    @Id
    @Column(name = "NAME")
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}
