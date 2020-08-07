package com.xiaxinyu.spring.transaction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author XIAXINYU3
 * @date 2020.8.7
 */
@TableName("user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
}