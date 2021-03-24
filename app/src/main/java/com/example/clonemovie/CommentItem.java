package com.example.clonemovie;

public class CommentItem {
    String comment;
    String userNickname;
    int recommendCount = 0;

    public CommentItem(String userNickname, String comment) {
        this.comment = comment;
        this.userNickname = userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(int recommendCount) {
        this.recommendCount = recommendCount;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "comment='" + comment + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", recommendCount=" + recommendCount +
                '}';
    }
}
