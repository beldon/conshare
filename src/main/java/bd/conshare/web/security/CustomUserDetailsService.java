package bd.conshare.web.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Beldon.
 * Copyright (c)  2017-03-18, All Rights Reserved.
 * http://beldon.me
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        SUser user = suserService.findUserByEmail(userName);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("UserName " + userName + " not found");
//        }


        // SecurityUser实现UserDetails并将SUser的Email映射为username
//        SecurityUser securityUser = new SecurityUser(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new org.springframework.security.core.userdetails.User("beldon", "111111", authorities);
        return new org.springframework.security.core.userdetails.User("user", "30666400d4bc3cc735f7e7d602506f0b908bbf256865f664e85c5a405e6c5d4455deff8bbc8108ba", authorities);
    }
}
