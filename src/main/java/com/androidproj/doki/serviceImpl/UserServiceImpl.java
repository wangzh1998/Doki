package com.androidproj.doki.serviceImpl;

import com.androidproj.doki.dao.UserDao;
import com.androidproj.doki.entity.User;
import com.androidproj.doki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService ,UserDetailsService{

    public UserServiceImpl() {

    }

    @Autowired
    UserDao userDao;


    //TODO
    @Override
    public User queryUser(int user_id) throws Exception{
        if(user_id < 0)
            throw new Exception("用户id小于0！");
        //return userDao.findUserByUniq_user_id(user_id);
        return new User();
    }

    //TODO
    @Override
    public User queryUser(String phone_num) throws Exception {
        if(phone_num==null || phone_num.length()==0)
            throw new Exception("电话号码为空！");
        //return userDao.findUserByPhone_number(phone_num);
        return new User();
    }

    //TODO 实现UserDetailsService，Spring Security是通过这个方法来验证用户名是否存在。那么，我们只需要将这个方法变更成通过手机号查找即可
    @Override
    public UserDetails loadUserByUsername(String phone_num) throws UsernameNotFoundException {
//        User user = userDao.findUserByPhone_number(phone_num);
//        if (user == null) {
//            throw new UsernameNotFoundException("当前号码不存在");
//        } else {
//            return user;
//        }
        return new User();
    }

}
