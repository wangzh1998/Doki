package com.androidproj.doki.service;

import com.androidproj.doki.entity.Saying;
import com.androidproj.doki.entity.User;

public interface SayingService {
    //添加说说
    void addSaying(Saying saying);

    //读取所有的公共说说
    void getAllPublicSaying();

    //读取和用户相关的说说
    void getRelatedPrivateSaying(User user);
}
