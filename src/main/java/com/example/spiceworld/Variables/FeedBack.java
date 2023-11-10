package com.example.spiceworld.Variables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.FEEDBACK_TABLE)
public class FeedBack {

    @PrimaryKey(autoGenerate = true)
    private int feedBackId;

    private String feedBack;
    private String start;

    private String userName;

    public FeedBack(String feedBack, String start, String userName) {
        this.feedBack = feedBack;
        this.start = start;
        this.userName = userName;
    }

    public int getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FeedBack: " + feedBack + "\n" +
                "Star: " + start + " UserName: " + userName +"\n\n";
    }
}
