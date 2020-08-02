package com.cimo.dao;

import com.cimo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ths
 * @create 2020/8/2 21:15
 */

@Repository
@Mapper
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 用户信息列表
     */
    List<User> findUserList();

    /**
     * 通过
     * @param name
     * @return
     */
    User findUserByName(@Param("name") String name);

    void saveUser(User user);

    void updateUser(User user);

}
