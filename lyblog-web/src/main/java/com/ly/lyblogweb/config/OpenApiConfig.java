package com.ly.lyblogweb.config;

/**
 * @Author: dly
 * @Date: 2025-07-07-22:37
 * @Description:
 */

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@OpenAPIDefinition(
        info = @Info(
                title = "示例项目 API 文档",
                version = "1.0",
                description = "这是一个示例项目的 API 接口文档",
                contact = @Contact(name = "名字", email = "your@email.com")
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "本地环境")
        }
)
public class OpenApiConfig {
}

