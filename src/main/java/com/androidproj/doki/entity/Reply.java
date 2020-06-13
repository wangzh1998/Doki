package com.androidproj.doki.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reply_id;


    //TODO 补充的
    int reply_pid = 0;//一级评论的父评论是0

    //int saying_id;//外键，直接在one端(saying)注明，此处不需要声明

    boolean is_public;

    //int user_id;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @CreationTimestamp
    Timestamp time;

    String reply_content;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},optional = false) //false表示saying不能为空
    @JoinColumn(name="saying_id")
    Saying saying;

    //TODO 补充的
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_pid",referencedColumnName = "reply_id")
    @OrderBy("id ASC")
    List<Reply> replyList; //该评论的子评论

    public Reply() {
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public int getReply_pid() {
        return reply_pid;
    }

    public void setReply_pid(int reply_pid) {
        this.reply_pid = reply_pid;
    }

    public Saying getSaying() {
        return saying;
    }

    public void setSaying(Saying saying) {
        this.saying = saying;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", reply_pid=" + reply_pid +
                ", is_public=" + is_public +
                ", user=" + user +
                ", time=" + time +
                ", reply_content='" + reply_content + '\'' +
                ", saying=" + saying +
                ", replyList=" + replyList +
                '}';
    }
}
