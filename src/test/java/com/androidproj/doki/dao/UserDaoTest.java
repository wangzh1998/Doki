package com.androidproj.doki.dao;

import com.androidproj.doki.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;

@DataJpaTest
//@DirtiesContext
public class UserDaoTest {

    @Autowired
    UserDao userDao ;
    @Autowired
    private EntityManager entityManager;

    @Test
    void findUserByUniq_user_id(){
        User user = new User();
        user.setGender(0);
        user.setNick_name("nick");
        user.setReal_name("real");
        user.setPassword("1234");
        user.setPhone_number("12345678909");
        user.setUser_image_src("image");
        System.out.println(userDao.save(user));
        //User findUser = userDao.findUserByUniq_user_id(1);
        //System.out.println(findUser);
    }

    @Test
    void findUserByPhone_num(){

    }
}
