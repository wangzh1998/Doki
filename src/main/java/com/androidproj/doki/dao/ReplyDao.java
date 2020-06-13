package com.androidproj.doki.dao;

import com.androidproj.doki.entity.Reply;
import com.androidproj.doki.entity.Saying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao extends JpaRepository<Reply,Integer> {
    //List<Reply> findAllBySaying(Saying saying);
}
