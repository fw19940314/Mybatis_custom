package com.lagou.dao;

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;


    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;

    /**
     *  用户新增
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 用户修改
     * @param user
     * @return
     */
    int update(User user);


    /**
     * 用户删除
     * @param user
     * @return
     */
    int delete(User user);


}
