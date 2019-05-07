package df;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello!");
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
