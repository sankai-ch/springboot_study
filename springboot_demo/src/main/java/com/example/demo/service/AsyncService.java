package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author SanKai
 * @since 2020-02-11
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public void addUser() {
        try {
            Thread.sleep(1000 * 5);
            log.info("==========处理积分==========");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    public void addUser2() {
        try {
            Thread.sleep(1000 * 5);
            log.info("==========处理积分==========");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}