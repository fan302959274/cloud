package com.cloud.zuul.config.oauth2;

import org.springframework.security.core.authority.AuthorityUtils;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private User user;

    /*  必须加 AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")不然不会验证*/
    public CustomUserDetails(User user) {
        super(user.getUsername(), user.getPassword(), true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}