package com.example.fm6app.domain;

import com.example.fm6app.common.security.UserAuthorities;

public enum Role {
    ROLE_ADMIN(UserAuthorities.ADMIN_AUTHORITIES),
    ROLE_USER(UserAuthorities.USER_AUTHORITIES);
    private String[] authorities;

    Role(String... userAuthorities) {
        this.authorities = userAuthorities;
    }
    public String[] getAuthorities(){
        return authorities;
    }
}
