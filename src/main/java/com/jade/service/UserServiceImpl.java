package com.jade.service;

import com.jade.bean.User;
import com.jade.bean.UserExample;
import com.jade.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        try {
            int insert = userMapper.insert(user);
            if (insert == 1) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserInfo(User user) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if (user != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
}
