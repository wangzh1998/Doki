package com.androidproj.doki.serviceImpl;

import com.androidproj.doki.entity.Saying;
import com.androidproj.doki.entity.User;
import com.androidproj.doki.service.ReplyService;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceImpl implements ReplyService {

    public ReplyServiceImpl() {
    }

    @Override
    public void getPublicReply(Saying saying) {

    }

    @Override
    public void getRelatedPrivateReply(Saying saying, User user) {

    }
}
