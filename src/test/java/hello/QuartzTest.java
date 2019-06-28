package hello;

import df.HelloJob;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
    @Test
    public void simpleTest() {
        Set<String> set = new HashSet<>();
        set.add(null);
        if (CollectionUtils.isEmpty(set)) {
            System.out.println("null");
        }

        String mcode = "1";
        if ("cc".endsWith(mcode)) {
            System.out.println("Hello!");
        }
        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            // and start it off
            scheduler.start();

            JobDetail job = newJob(HelloJob.class).withIdentity("job1","group1").build();
            Trigger trigger = newTrigger().withIdentity("trigger1","group1").withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
