package hello;

import df.quartz.MailJob;
import df.quartz.StoppableJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
    @Test
    public void simpleTest() throws InterruptedException, SchedulerException {
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Date startTime = DateBuilder.nextGivenSecondDate(null, 8);

        //定义一个触发器
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义名称和所属的组
                .startAt(startTime)
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(2) //每隔2秒执行一次
                        .withRepeatCount(10)) //总共执行11次(第一次执行不基数)
                .build();

        //定义一个JobDetail
        JobDetail job = newJob(MailJob.class) //指定干活的类MailJob
                .withIdentity("mailjob1", "mailgroup") //定义任务名称和分组
                .usingJobData("email", "admin@10086.com") //定义属性
                .build();

        //调度加入这个job
        scheduler.scheduleJob(job, trigger);

        //启动
        scheduler.start();

        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown(true);

    }

    @Test
    public void interrupt() throws InterruptedException, SchedulerException {
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //定义一个触发器
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义名称和所属的组
                .startNow()
                .build();

        //定义一个JobDetail
        JobDetail job = newJob(StoppableJob.class) //指定干活的类MailJob
                .withIdentity("exceptionJob1", "someJobGroup") //定义任务名称和分组
                .build();

        //调度加入这个job
        scheduler.scheduleJob(job, trigger);

        //启动
        scheduler.start();

        Thread.sleep(5000);
        System.out.println("过5秒，调度停止 job");
        System.out.println(job.getKey());
        scheduler.interrupt(job.getKey());
        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown(true);

    }

}
