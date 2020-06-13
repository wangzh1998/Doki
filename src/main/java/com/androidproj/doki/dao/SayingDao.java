package com.androidproj.doki.dao;

import com.androidproj.doki.entity.Saying;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SayingDao extends JpaRepository<Saying,Integer> {
    List<Saying> findAll();
    //Saying findBySaying_id(int saying_id);
}
