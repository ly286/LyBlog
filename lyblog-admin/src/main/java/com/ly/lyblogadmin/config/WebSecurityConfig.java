package com.ly.lyblogadmin.config;

import com.ly.lyblogsecurity.filter.JwtAuthenticationFilter;
import com.ly.lyblogsecurity.handler.RestAuthenticationFailureHandler;
import com.ly.lyblogsecurity.handler.RestAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: dly
 * @Date: 2025-07-09-23:50
 * @Description: 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public WebSecurityConfig(DaoAuthenticationProvider daoAuthenticationProvider) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                                           RestAuthenticationSuccessHandler successHandler,
                                                           RestAuthenticationFailureHandler failureHandler) {
        return new JwtAuthenticationFilter(authenticationManager, successHandler, failureHandler);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 禁用 CSRF
                .formLogin(form -> form.disable()) // 禁用表单登录
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 前后端分离，无需 session
                .authenticationProvider(daoAuthenticationProvider) // 注册 DaoAuthenticationProvider
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // 注册 JWT 登录 Filter
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll() // 放行登录接口
                        .requestMatchers("/admin/**").authenticated() // /admin/** 需要认证
                        .anyRequest().permitAll()); // 其他请求放行

        return http.build();
    }
}


