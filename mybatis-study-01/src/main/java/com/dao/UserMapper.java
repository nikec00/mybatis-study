package com.dao;

import com.entity.User;

import java.util.List;

/**
 * @author nkc
 * @date 22/3/24
 */
public interface UserMapper {

    /**
     * 新增
     * @return
     */
    int insert();

    /**
     * 修改
     * @return
     */
    int update();


    List<User> selectAll();
}
