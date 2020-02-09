//package com.example.demo.common.config;
//
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author SanKai
// * @since 2020-02-07
// */
//@Component
//public class Recevier {
//
//
//    @RabbitListener(queues = SenderConfig.QUEUENAME)
//    public void process(String msg) {
//        System.out.println("receiver：" + msg);
//    }
//}
