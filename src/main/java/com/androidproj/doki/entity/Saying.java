package com.androidproj.doki.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Saying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int saying_id;

    @OneToOne
    @JoinColumn(name = "from_user_id")
    User from_user;

    //@Column(nullable = false) //@Column(s) not allowed on a @OneToOne property: com.androidproj.doki.entity.Saying.to_user
    @OneToOne
    @JoinColumn(name = "to_user_id")
    User to_user; //to_user可以为空，但是当它不为空时，和to_user_phone_num字段会有冗余

    String to_user_phone_num;

    @Column(nullable = false)
    @CreationTimestamp
    Timestamp time;

    //@Lob //大对象
    String contents;
    String saying_image_src;
    boolean is_public;

    @OneToMany(mappedBy = "saying",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(name = "saying_id")
    @OrderBy("id DESC")
    @Where(clause = "reply_pid=0")
    List<Reply> replyList = new ArrayList<>();


    public Saying() {
    }

    public int getSaying_id() {
        return saying_id;
    }

    public void setSaying_id(int saying_id) {
        this.saying_id = saying_id;
    }

    public User getFrom_user() {
        return from_user;
    }

    public void setFrom_user(User from_user) {
        this.from_user = from_user;
    }

    public User getTo_user() {
        return to_user;
    }

    public void setTo_user(User to_user) {
        this.to_user = to_user;
    }

    public String getTo_user_phone_num() {
        return to_user_phone_num;
    }

    public void setTo_user_phone_num(String to_user_phone_num) {
        this.to_user_phone_num = to_user_phone_num;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getSaying_image_src() {
        return saying_image_src;
    }

    public void setSaying_image_src(String saying_image_src) {
        this.saying_image_src = saying_image_src;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    @Override
    public String toString() {
        return "Saying{" +
                "saying_id=" + saying_id +
                ", from_user=" + from_user +
                ", to_user=" + to_user +
                ", to_user_phone_num='" + to_user_phone_num + '\'' +
                ", time=" + time +
                ", contents='" + contents + '\'' +
                ", saying_image_src='" + saying_image_src + '\'' +
                ", is_public=" + is_public +
                ", replyList=" + replyList +
                '}';
    }
}
