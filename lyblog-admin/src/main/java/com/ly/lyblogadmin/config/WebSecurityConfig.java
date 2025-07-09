package com.ly.lyblogadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @Author: dly
 * @Date: 2025-07-09-23:50
 * @Description: 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").authenticated() //认证所有以/admin开头的请求
                        .anyRequest().permitAll() //其他请求不需要认证
                )
                .formLogin(withDefaults()) //表单登录
                .httpBasic(withDefaults()) //http基本认证
                .build();
    }
}

