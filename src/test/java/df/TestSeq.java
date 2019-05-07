package df;

import df.mybatis.mapper.SeqMapper;
import df.util.MyValidator;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSeq {
    static Logger logger = LoggerFactory.getLogger(TestSeq.class);

    @Autowired
    SeqMapper seqMapper;
    @Autowired
    MyValidator myValidator;

    @Autowired(required = false)
    StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    CountDownLatch latch;

    @Test
    public void testGetSeq() {
        logger.info("Enter...");
        Long b = System.currentTimeMillis();
        Long e = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(this.seqMapper.getSeq());
            e = System.currentTimeMillis();
            if (i == 0) {

                System.out.println("first time:" + (e - b) + "ms");
            }
        }
        e = System.currentTimeMillis();
        System.out.println("cost average time:" + (e - b) / 100 + "ms");
    }

    @Test
    public void testHttp() throws MalformedURLException {
        logger.info("Enter testHttp...");
        Resource resource = new UrlResource("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/css/super_min_e8edd1e3.css");
        try {
//            byte[] buffer = new byte[102400];
//            int ret = IOUtils.read(resource.getInputStream(), buffer);
            File file = new File("./testSrping.css");
            OutputStream out = new FileOutputStream(file);
            IOUtils.copy(resource.getInputStream(), out);
//            FileUtils.writeByteArrayToFile(file, buffer, 0, ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValidate() throws MalformedURLException {
        PayRequestDto dto = new PayRequestDto();
        dto.setPayTime("2018");
        dto.setUaId(-1L);
        try {
//            ValidationUtils.validate(dto);
            myValidator.validate(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRedisMessage() throws InterruptedException {
        logger.info("Sending message...");
        stringRedisTemplate.convertAndSend("chat", "Hello from Redis");
        latch.await();
    }
}
