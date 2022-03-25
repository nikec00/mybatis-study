package com.dao;

import com.entity.User;

import java.util.List;

/**
 * @author nkc
 * @date 22/3/24
 */
public interface IUserMapper {

    List<User> getUserAll();

    List<User> getUserAll2();
}
