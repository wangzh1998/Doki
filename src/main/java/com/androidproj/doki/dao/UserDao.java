package com.androidproj.doki.dao;

import com.androidproj.doki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findAll();
    //User findUserByUniq_user_id(int user_id);
    //User findUserByPhone_number(String phone_num);
}
