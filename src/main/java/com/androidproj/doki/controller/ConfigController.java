package com.androidproj.doki.controller;

import com.androidproj.doki.entity.User;
import com.androidproj.doki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
@RequestMapping({"/login"})
public class ConfigController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public ConfigController() {
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @ResponseBody
    @RequestMapping({"/return0"})
    public String return0() throws Exception {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String phone_number = userDetails.getUsername();
        User user = this.userService.queryUser(phone_number);
        if(user==null)return "当前用户不存在";
        else return "登陆成功";
    }

    @RequestMapping({"/return1"})
    public String return1() {
        return "redirect:/index.html";
    }

    @RequestMapping({"/signIn"})
    public String signIn() {
        return "SignIn";
    }

    @RequestMapping({"/signOut"})
    public String signOut() {
        return "SignOut";
    }

    @RequestMapping({"/getPassword"})
    public String getPassword(@RequestParam(value = "password",required = true) String password) {
        String tmp = this.bCryptPasswordEncoder.encode(password);
        return tmp;
    }
}
