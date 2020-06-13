package com.androidproj.doki.entity;

//import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id //这个注解对应的包是javax.persistence.*，而不是org.springframework.data.annotation.Id。如果搞错了，会有No identifier specified for entity:的报错。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniq_user_id;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    int gender;

    @Column(nullable = true)
    Date birthday;

    @Column(nullable = false)
    String real_name;

    @Column(nullable = false)
    String nick_name;

    @Column (nullable = true)
    String email;

    @Column(nullable = false)
    String phone_number;

    @Column(nullable = false)
    String user_image_src;

    public User() {

    }

    public int getUniq_user_id() {
        return uniq_user_id;
    }

    //TODO 这里权限为空
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList();
//        if (this.roleId == -1 || this.roleName==null||this.roleName.isEmpty()) {//this.role == null
//            System.out.println("UserAndRole:role error");
//        } else {
//            auths.add(new SimpleGrantedAuthority());
//        }

        return auths;
    }

    public String getPassword() {
        return password;
    }

    //TODO 这里给userdetails中用的是phone_number
    @Override
    public String getUsername() {
        return phone_number;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getReal_name() {
        return real_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getUser_image_src() {
        return user_image_src;
    }

    public void setUniq_user_id(int uniq_user_id) {
        this.uniq_user_id = uniq_user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUser_image_src(String user_image_src) {
        this.user_image_src = user_image_src;
    }

    @Override
    public String toString() {
        return "User{" +
                "uniq_user_id=" + uniq_user_id +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", real_name='" + real_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", user_image_src='" + user_image_src + '\'' +
                '}';
    }
}
