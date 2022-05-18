package com.example.mybatispluspage.tasks;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

// 将jobDataMap持久化,需要数据库在官网下载脚本
//@PersistJobDataAfterExecution
// 禁止tasks并发执行
@DisallowConcurrentExecution
public class QuartzTasks extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务执行时间" + new SimpleDateFormat("yy-MM-dd:HH:ss").format(new Date()));
    }

}
