package com.ovia.model.mood;

import com.ovia.model.JsonModelObject;
import com.ovia.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "MOODSTATUS")
public class MoodStatus extends JsonModelObject {
    @Id
    @Column(name = "user_name")
    private String userId;

    @Column(name = "level")
    private int level;

    @Column(name = "date")
    private LocalDate date;

    public MoodStatus() {}

    public MoodStatus(String userId, int Level) {
        this.userId = userId;
        this.level = level;
        this.date = LocalDate.now();
    }

    public MoodStatus(String userId, int level, LocalDate date) {
        this.userId = userId;
        this.level = level;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
