package com.cloud.zuul.config.oauth2;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //从数据库中按照username获取用户信息与页面传来的用户信息比较
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /*模拟数据库操作*/
        User user = new User();
        user.setUsername("10086");
        String password = "123456";
        user.setPassword(password);
        return new CustomUserDetails(user);
    }

}