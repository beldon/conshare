package bd.conshare.web.security;

import bd.conshare.web.module.user.domain.User;
import bd.conshare.web.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Beldon.
 * Copyright (c)  2017-03-18, All Rights Reserved.
 * http://beldon.me
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {


        Optional<User> userOptional = userService.findByAccount(account);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("用户名 " + account + " 不存在");
        }

        User user = userOptional.get();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(account, user.getPassword(), authorities);
    }
}
