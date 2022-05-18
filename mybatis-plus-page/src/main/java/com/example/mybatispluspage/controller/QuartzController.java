package com.example.mybatispluspage.controller;


import com.example.mybatispluspage.tasks.QuartzTasks;
import com.example.mybatispluspage.utils.R;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("quartz")
public class QuartzController {

    // 获取调度器方式1,通过ioc
    @Autowired
    private Scheduler scheduler;
    private String tasksId;
    private String tasksGroup;

    // 获取调度器方式1，通过工厂
     /*private Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
     public QuartzController() throws SchedulerException {
     }*/

    /**
     * 开启一个定时任务
     * @param tasksId
     * @param tasksGroup
     * @return
     */
    @GetMapping("quartz")
    public R startTasks(@RequestParam("tasksId") String tasksId, @RequestParam("tasksGroup") String tasksGroup){
        // 创建一个开始时间，在startAt的时候使用,如果使用的是startNow那么就不用启动时间，如果两个同时写了，位于后面的会生效
        Date start = new Date();

        // 创建jobDetail
        JobDetail jobDetail = JobBuilder.newJob(QuartzTasks.class)
                .withIdentity(tasksId, tasksGroup)
                // .storeDurably(true) // 持久化存储
                // 给jobDetail传递一些参数
                .usingJobData("name", "liqisong")
                .usingJobData("age", 12)
                .build();

        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                // 给jobDetail传递一些参数
                .usingJobData("haha", "liqisong")
                .usingJobData("h", 12)
                .withIdentity(tasksId, tasksGroup)
                .startAt(start)
                // 多久一次
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()
                )
                .build();

        try{
            // 通过调度器开始定时任务
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            // 成功返回数据
            return R.ok("定时任务启动成功");
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error("定时任务启动失败");
        }
    }


    /**
     * 暂停任务
     * @param tasksId
     * @param tasksGroup
     * @return
     */
    @GetMapping("pause")
    public R pause(@RequestParam("tasksId") String tasksId, @RequestParam("tasksGroup") String tasksGroup){
        TriggerKey triggerKey = new TriggerKey(tasksId, tasksGroup);
        try{
            scheduler.pauseTrigger(triggerKey); // 暂定trigger触发器
            // 成功返回数据
            return R.ok("任务暂停成功");
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error("任务暂停失败");
        }
    }


    /**
     * 定时任务回复运行
     * @param tasksId
     * @param tasksGroup
     * @return
     */
    @GetMapping("resume")
    public R resume(@RequestParam("tasksId") String tasksId, @RequestParam("tasksGroup") String tasksGroup){
        TriggerKey triggerKey = new TriggerKey(tasksId, tasksGroup);
        try{
            scheduler.resumeTrigger(triggerKey); // 恢复trigger触发器
            // 成功返回数据
            return R.ok("任务恢复成功");
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error("任务恢复失败");
        }
    }


    /**
     * 删除定时任务，删除之后只能通过新建一个任务来开启
     * @param tasksId
     * @param tasksGroup
     * @return
     */
    @GetMapping("del")
    public R del(@RequestParam("tasksId") String tasksId, @RequestParam("tasksGroup") String tasksGroup){
        TriggerKey triggerKey = new TriggerKey(tasksId, tasksGroup);
        JobKey jobKey = new JobKey(tasksId, tasksGroup);
        try{
            scheduler.pauseTrigger(triggerKey); // 暂停trigger触发器
            scheduler.unscheduleJob(triggerKey); // 移除trigger触发器
            scheduler.deleteJob(jobKey); // 删除job任务
            // 成功返回数据
            return R.ok("删除任务成功");
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error("删除任务失败");
        }
    }






}
