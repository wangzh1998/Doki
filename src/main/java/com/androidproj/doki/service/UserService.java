package com.androidproj.doki.service;

import com.androidproj.doki.dao.UserDao;
import com.androidproj.doki.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService{
    //根据用户id查询用户
    User queryUser(int user_id) throws Exception;
    //根据电话号码查询用户
    User queryUser(String phone_num) throws Exception;
}
