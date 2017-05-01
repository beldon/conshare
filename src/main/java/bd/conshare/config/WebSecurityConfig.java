package bd.conshare.config;

import bd.conshare.web.handler.UserAuthenticationFailureHandler;
import bd.conshare.web.handler.UserAuthenticationSuccessHandler;
import bd.conshare.web.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by Beldon.
 * Copyright (c)  2017-03-17, All Rights Reserved.
 * http://beldon.me
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String PASSWORD_SECRET = "beldon";

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private StandardPasswordEncoder standardPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                .antMatchers("/user/**")
                .authenticated()
                .antMatchers("/**", "/user/reg","/user/doReg")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/doLogin.json")
                .successForwardUrl("/user/")
                .usernameParameter("account")
                .passwordParameter("password")
                .successHandler(new UserAuthenticationSuccessHandler())
                .failureHandler(new UserAuthenticationFailureHandler())
                .permitAll()
                .and().csrf().disable();

        http.rememberMe().key("rememberMe").alwaysRemember(true);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(standardPasswordEncoder);
    }

    @Bean
    public StandardPasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder(PASSWORD_SECRET);
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }
}
