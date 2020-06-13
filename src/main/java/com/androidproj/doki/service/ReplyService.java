package com.androidproj.doki.service;

import com.androidproj.doki.entity.Saying;
import com.androidproj.doki.entity.User;

public interface ReplyService {
    //读取当前说说的公共评论
    void getPublicReply(Saying saying);

    //读取当前说说的公共评论
    void getRelatedPrivateReply(Saying saying, User user);
}
