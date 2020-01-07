package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    /**
     * 新增
     * @param configuration
     * @param mappedStatement
     * @param params
     * @return
     * @throws Exception
     */
    int insert(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    /**
     * 修改
     * @param configuration
     * @param mappedStatement
     * @param params
     * @return
     * @throws Exception
     */
    int update(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    /**
     * 删除
     * @param configuration
     * @param mappedStatement
     * @param params
     * @return
     * @throws Exception
     */
    int delete(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;


}
