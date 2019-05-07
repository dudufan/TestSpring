package df;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Application.class);
//        testRedisMessage(ctx);
        ((ConfigurableApplicationContext) ctx).registerShutdownHook();
        Book book = ctx.getBean(Book.class);
        LOGGER.info("book.name:"+book.name);
        LOGGER.info("book.author:"+book.author);

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
    }
}
