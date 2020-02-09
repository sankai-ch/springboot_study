//package com.example.demo.common.config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @author SanKai
// * @since 2020-02-07
// */
//
//@Component
//public class Sender {
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    public void send() {
//        String msg = "hello" + new Date();
//        amqpTemplate.convertAndSend(SenderConfig.QUEUENAME, msg);
//    }
//
//}
