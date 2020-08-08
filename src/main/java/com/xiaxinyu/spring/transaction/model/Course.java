package com.xiaxinyu.spring.transaction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author XIAXINYU3
 * @date 2020.8.7
 */
@TableName("course")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer userId;
}