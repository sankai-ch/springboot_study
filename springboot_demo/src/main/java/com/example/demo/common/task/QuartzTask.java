package com.example.demo.common.task;

import com.example.demo.service.NotifyService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author SanKai
 * @since 2020-02-12
 */
public class QuartzTask extends QuartzJobBean {
    @Autowired
    private NotifyService notifyService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + " QuartzTask定时任务执行");
        notifyService.sendMessageToUser();
    }
}
