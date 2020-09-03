package main.java.com.neusoft.dao;

import main.java.com.neusoft.domain.User;

import java.util.List;

public interface IUserDao {

        // 查询所有
        List<User> findAll();
    }

