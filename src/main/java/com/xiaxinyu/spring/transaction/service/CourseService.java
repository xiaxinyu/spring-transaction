package com.xiaxinyu.spring.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaxinyu.spring.transaction.mapper.CourseMapper;
import com.xiaxinyu.spring.transaction.mapper.UserMapper;
import com.xiaxinyu.spring.transaction.model.Course;
import com.xiaxinyu.spring.transaction.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author summer
 * @date 2020.8.10
 */
@Slf4j
@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Transactional(rollbackFor = Exception.class)
    public Course add(Course course) {
        log.info("=== Starting adding course ===");
        courseMapper.insert(course);
        log.info("=== Starting adding course ===");
        return course;
    }

    public Course find(Integer id) {
        return courseMapper.selectById(id);
    }

    public void deleteAll(){
        LambdaQueryWrapper query = Wrappers.lambdaQuery();
        courseMapper.delete(query);
    }
}
