package com.nnlight.common;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QuartzUtil {

    public static void addJob(Class jobClass, Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateStr = dateFormat.format(date);
        String[] dateArray = dateStr.split("-");
        StringBuilder cron = new StringBuilder();
        cron.append(dateArray[5]);
        cron.append(" ");
        cron.append(dateArray[4]);
        cron.append(" ");
        cron.append(dateArray[3]);
        cron.append(" ");
        cron.append(dateArray[2]);
        cron.append(" ");
        cron.append(dateArray[1]);
        cron.append(" ");
        cron.append("?");
        cron.append(" ");
        cron.append(dateArray[0]);

        addJob("jobName" + String.valueOf(new Date().getTime()), DEFAULT_JOB_GROUP_NAME,
                "tiggerName" + String.valueOf(new Date().getTime()), DEFAULT_TRIGGER_GROUP_NAME, jobClass, cron.toString());
    }

    /**
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务
     * @param cron             时间设置，参考quartz说明文档
     * @Description: 添加一个定时任务
     */
    public static void addJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName, Class jobClass, String cron) {
        try {
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            if (!sched.isStarted()) {
                sched.start();
            }

            JobDetail jobDetail = newJob(jobClass).withIdentity(jobName, jobGroupName).build();

            //触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            sched.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        QuartzUtil.addJob(DEFAULT_JOB_NAME, DEFAULT_JOB_GROUP_NAME, DEFAULT_TRIGGER_NAME,
//                DEFAULT_TRIGGER_GROUP_NAME, TestJob.class, "0 44 16 3 7 ? 2018");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        try {
            Date date1 = dateFormat.parse("2018-7-4-9-10-00");
            addJob(TestJob.class, date1);
            TimeUnit.MINUTES.sleep(3);
            Date date2 = dateFormat.parse("2018-7-4-9-15-00");
            addJob(TestJob.class, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static final String DEFAULT_JOB_NAME = "default_Job_Name";
    public static final String DEFAULT_TRIGGER_NAME = "default_trigger_name";
    public static final String DEFAULT_JOB_GROUP_NAME = "default_jobgroup_name";
    public static final String DEFAULT_TRIGGER_GROUP_NAME = "default_trigger_group_name";

    public static class TestJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.print("定时器执行：");
            System.out.println(LocalDate.now() + " " + LocalTime.now());
        }
    }
}
