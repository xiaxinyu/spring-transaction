package com.xiaxinyu.spring.transaction.domain;

import com.xiaxinyu.spring.transaction.domain.dto.UserDTO;
import com.xiaxinyu.spring.transaction.model.Course;
import com.xiaxinyu.spring.transaction.model.User;
import com.xiaxinyu.spring.transaction.service.CourseService;
import com.xiaxinyu.spring.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Component
public class UserDomain {
    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveUser(UserDTO userDto) {
        User user = userDto.getUser();
        userService.add(user);

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("------------------> error={}", e.getMessage());
        }


        Course course = userDto.getCourse();
        course.setUserId(user.getId());
        courseService.add(course);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        courseService.deleteAll();
        userService.deleteAll();

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                log.info("Deleting all user and course is finishing");
            }
        });
    }
}
