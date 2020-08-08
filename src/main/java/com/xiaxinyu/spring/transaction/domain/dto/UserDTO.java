package com.xiaxinyu.spring.transaction.domain.dto;

import com.xiaxinyu.spring.transaction.model.Course;
import com.xiaxinyu.spring.transaction.model.User;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private User user;
    private Course course;
}
