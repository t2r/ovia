package com.ovia.model.event;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOODEVENT")
public class MoodEvent extends BaseEvent {
    public MoodEvent() {}

    public MoodEvent(String userName, String moodType) {
        this.userName = userName;
        this.moodType = moodType;
        this.dateTime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mood_type")
    private String moodType;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoodType() {
        return moodType;
    }

    public void setEventType(String moodType) {
        this.moodType = moodType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
