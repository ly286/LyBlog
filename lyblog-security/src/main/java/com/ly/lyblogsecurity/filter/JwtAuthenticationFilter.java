package com.ly.lyblogsecurity.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.lyblogsecurity.exception.UsernameOrPasswordNullException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @Author: dly
 * @Date: 2025-07-10-10:17
 * @Description:
 */
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   AuthenticationSuccessHandler successHandler,
                                   AuthenticationFailureHandler failureHandler) {
        this.authenticationManager = authenticationManager;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        if ("/admin/login".equals(request.getServletPath()) && "POST".equalsIgnoreCase(request.getMethod())) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(request.getInputStream());
                String username = jsonNode.get("username").asText();
                String password = jsonNode.get("password").asText();

                if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                    throw new UsernameOrPasswordNullException("用户名或密码不能为空");
                }

                UsernamePasswordAuthenticationToken authRequest =
                        new UsernamePasswordAuthenticationToken(username, password);

                Authentication authResult = authenticationManager.authenticate(authRequest);

                // 认证成功调用 successHandler
                successHandler.onAuthenticationSuccess(request, response, authResult);
                return;

            } catch (AuthenticationException ex) {
                log.error("登录失败: {}", ex.getMessage());
                // 认证失败调用 failureHandler
                failureHandler.onAuthenticationFailure(request, response, ex);
                return;
            }
        }

        // 非登录请求继续走过滤链
        filterChain.doFilter(request, response);
    }
}



