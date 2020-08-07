package com.xiaxinyu.spring.transaction.service;

import com.xiaxinyu.spring.transaction.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test_add_user() {
        //DataSourceTransactionManager
        User user = User.builder().name("winner").age(19).build();
        userService.add(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void test_find_user() {
        User user = userService.find(1);
        Assert.assertNotNull(user.getId());
    }
}
