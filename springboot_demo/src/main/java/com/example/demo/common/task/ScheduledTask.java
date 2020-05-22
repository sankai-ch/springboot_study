package com.example.demo.common.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author SanKai
 * @since 2020-02-12
 */

@Component
@Deprecated
public class ScheduledTask {
//
//    /**
//     * cron：通过表达式来配置任务执行时间
//     */
//    @Scheduled(cron = "0/10 * * * * *")
//    public void scheduled1() {
//        System.out.println(new Date() + " Scheduled1定时任务启动");
//    }
//
//    /**
//     * fixedRate  定义一个按一定频率执行的定时任务
//     */
//    @Scheduled(fixedRate = 5000)
//    public void scheduled2() {
//        System.out.println(new Date() + " Scheduled2定时任务启动");
//    }
//
//    /**
//     * fixedDelay  定义一个按一定频率执行的定时任务，与上面不同的是
//     * 该属性可以配合initialDelay,定义该任务延迟执行时间
//     *
//     * @Scheduled(initialDelay = 1000, fixedRate = 5000);
//     * 第一次延迟一秒后执行，之后按fixedRate的规则每5秒执行一次。
//     */
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled3() {
//        System.out.println(new Date() + " Scheduled3定时任务启动");
//    }
}
