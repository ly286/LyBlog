package com.ly.lyblogweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class LyblogWebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testLog() {
        log.info("info");
        log.warn("warn");
        log.error("error");

        String author = "ly";
        log.info("author:{}", author);
    }
}
