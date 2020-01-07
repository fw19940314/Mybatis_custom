package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class IPersistenceTest {
    SqlSession sqlSession;

    @Before
    public void beforeHandle() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() throws Exception {
//        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);


//        //调用
//        User user = new User();
//        user.setId(1);
//        user.setUsername("张三");
//        User user2 = sqlSession.selectOne("user.selectOne", user);
//
//        System.out.println(user2);

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//
//        List<User> all = userDao.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }

    }


    /**
     * 新增测试
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(11);
        user.setUsername("杭州666");
        int result = sqlSession.insert("com.lagou.dao.IUserDao.insert", user);
        checkSuccess(result);
    }

    /**
     * 新增操作(动态代理方式)
     */
    @Test
    public void insertProxy() {
        User user = new User();
        user.setId(88);
        user.setUsername("hello");
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int result = mapper.insert(user);
        checkSuccess(result);

    }

    /**
     * 修改测试
     *
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(77);
        user.setUsername("mybatis1333");
        int result = sqlSession.update("com.lagou.dao.IUserDao.update", user);
        checkSuccess(result);
    }


    /**
     * 修改测试（代理方式）
     *
     * @throws Exception
     */
    @Test
    public void updateProxy() throws Exception {
        User user = new User();
        user.setId(6);
        user.setUsername("拉钩666");
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int result = mapper.update(user);
        checkSuccess(result);
    }

    /**
     * 删除测试
     *
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setId(6);
        int result = sqlSession.delete("com.lagou.dao.IUserDao.delete", user);
        checkSuccess(result);
    }


    /**
     * 删除测试（代理方式）
     */
    @Test
    public void deleteProxy() {
        User user = new User();
        user.setId(2);
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int result = mapper.delete(user);
        checkSuccess(result);
    }


    /**
     * 返回结果判断
     *
     * @param arg
     */
    public void checkSuccess(int arg) {
        TestCase.assertSame(1, arg);
    }


}
