package com.lqs.springsecuritydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqs.springsecuritydemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:43
 * @do :
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUserByUserName(@Param("userName") String userName);

    void addUser(User user);
}
