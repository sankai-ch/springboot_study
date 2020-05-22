package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author SanKai
 * @since 2020-02-12
 */
@Service
public class NotifyService {

    public void sendMessageToUser() {
        System.out.println(new Date() + " 通知方法被定时任务调用，开始发送通知");
    }
}
