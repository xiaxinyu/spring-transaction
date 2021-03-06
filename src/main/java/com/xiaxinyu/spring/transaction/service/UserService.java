package com.xiaxinyu.spring.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaxinyu.spring.transaction.mapper.UserMapper;
import com.xiaxinyu.spring.transaction.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public User add(User user) {
        log.info("=== Starting adding user ===");
        userMapper.insert(user);
        log.info("=== Ending adding user ===");
        return user;
    }

    public User find(Integer id) {
        return userMapper.selectById(id);
    }

    public void deleteAll(){
        LambdaQueryWrapper query = Wrappers.lambdaQuery();
        userMapper.delete(query);
    }
}
