package com.xiaxinyu.spring.transaction.service;

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
        userMapper.insert(user);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                log.info("Add user is finishing");
            }
        });
        return user;
    }

    public User find(Integer id) {
        return userMapper.selectById(id);
    }
}
