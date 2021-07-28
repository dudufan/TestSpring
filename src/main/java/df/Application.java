package df;

import df.bean.RemoteProperties;
import df.bean.TestConfig;
import df.generic.BjLoginService;
import df.listener.HelloSpringApplicationRunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, ActiveMQAutoConfiguration.class})
public class Application implements CommandLineRunner, WebMvcConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("main...starting...");
        ApplicationContext ctx = SpringApplication.run(Application.class);

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
