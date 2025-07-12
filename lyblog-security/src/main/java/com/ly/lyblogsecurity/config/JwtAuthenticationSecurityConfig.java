package com.ly.lyblogsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: dly
 * @Date: 2025-07-10-10:49
 * @Description:
 * 这是 Spring Security 6.x 版本下自定义的 JWT 安全配置类。
 * 主要用于配置登录过滤器、认证提供者和登录成功/失败处理器。
 */
@Configuration
public class JwtAuthenticationSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationSecurityConfig(PasswordEncoder passwordEncoder,
                                           UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    /**
     * 手动暴露 AuthenticationManager Bean
     * Spring Security 6.x 不再自动暴露，需要通过 AuthenticationConfiguration 获取
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * 配置 DaoAuthenticationProvider
     * DaoAuthenticationProvider 是 Spring Security 6.x 的默认认证提供者
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
