package df;

import df.mybatis.mapper.SeqMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    SeqMapper seqMapper;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Application.class);
//        testRedisMessage(ctx);
        System.exit(0);
    }

    private static void testRedisMessage(ApplicationContext ctx) throws InterruptedException {
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
        LOGGER.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis");
        template.persist("aaa");
        latch.await();
    }


    @Override
    public void run(String... args) throws Exception {

        Long b = System.currentTimeMillis();
        Long e = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(this.seqMapper.getSeq());
            e = System.currentTimeMillis();
            if (i == 0) {

                System.out.println("first time:" + (e-b) + "ms");
            }
        }
        e = System.currentTimeMillis();
        System.out.println("cost average time:" + (e-b)/100 + "ms");
    }
}
