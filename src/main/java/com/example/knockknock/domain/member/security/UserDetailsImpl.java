package com.example.knockknock.domain.member.security;

import com.example.knockknock.domain.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 로그인시 인증된 사용자의 정보를 갖고있는 클래스
* UserDetailsService에서 반환하는 User 객체, 파라미터를 받아 생성됨*/
public class UserDetailsImpl implements UserDetails {

    private final Member user;
    private final String id;

    public UserDetailsImpl(Member user, String id) {
        this.user = user;
        this.id = id;
    }

    public Member getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    // 인증에 사용될 이름(이메일)
    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}