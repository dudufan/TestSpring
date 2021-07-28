package df.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            JobDetail detail = context.getJobDetail();
            String email = detail.getJobDataMap().getString("email");

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String now = sdf.format(new Date());

            System.out.printf("给邮件地址 %s 发出了一封定时邮件, 当前时间是: %s%n" ,email, now);
        } catch (Exception e) {
            JobExecutionException je = new JobExecutionException(e);
            je.setUnscheduleAllTriggers(true);
            throw je;
        }
    }

    public static void main(String[] args) {
        long a= 9000000000000000000L;
        long b= a * 1000;
        System.out.println();
//        long validtime = System.currentTimeMillis() + ;
//        Date pubkeyValidTime = new Date(validtime);
//        Date now = new Date();
//        if (pubkeyValidTime.before(now)) {
//            System.out.println("Error!!!!");
//        }
    }
}
