package com.xiaxinyu.spring.transaction.domain;

import com.xiaxinyu.spring.transaction.domain.dto.UserDTO;
import com.xiaxinyu.spring.transaction.model.Course;
import com.xiaxinyu.spring.transaction.model.User;
import com.xiaxinyu.spring.transaction.service.CourseService;
import com.xiaxinyu.spring.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserDomainTest {

    @Autowired
    UserDomain userDomain;


    @Test
    public void deleteAll() {
        userDomain.deleteAll();
    }

    @Test
    public void test_add_user() {
        userDomain.deleteAll();

        User user = User.builder().name("winner").age(19).build();
        Course course = Course.builder().name("Java").build();
        UserDTO userDto = UserDTO.builder().user(user).course(course).build();
        userDomain.saveUser(userDto);
    }
}
