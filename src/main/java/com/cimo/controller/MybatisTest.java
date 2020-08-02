package com.cimo.controller;

import com.cimo.dao.UserDao;
import com.cimo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ths
 * @create 2020/8/2 21:22
 */

@RestController
public class MybatisTest {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/findUserList")
    public List<User> findUserList(){
        return userDao.findUserList();
    }

}
