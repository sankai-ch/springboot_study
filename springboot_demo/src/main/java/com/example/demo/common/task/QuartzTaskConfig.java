package com.example.demo.common.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SanKai
 * @since 2020-02-12
 */

/**
 * 定义job的执行时间为每5秒执行一次，这个设置可以自行修改，之后在类上新增@Configuration 注解将其注册到IOC容器中
 * 否则该类不会生效
 */
@Configuration
public class QuartzTaskConfig {

    @Bean
    public JobDetail simpleJobDetail() {
        return JobBuilder.newJob(QuartzTask.class).withIdentity("quartzTaskJob").storeDurably().build();
    }

    @Bean
    public Trigger simpleJobTrigger() {
        //定义每 5 秒 执行一次
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        //定义触发器
        return TriggerBuilder.newTrigger().forJob(simpleJobDetail()).withIdentity("quartzTaskJobTrigger").withSchedule(simpleScheduleBuilder).build();
    }

}
