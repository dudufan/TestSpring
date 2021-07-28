package df;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import df.mybatis.mapper.SeqMapper;
import df.validator.MyValidator;
import df.validator.PayRequestDto;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class TestJMockData {
    static Logger logger = LoggerFactory.getLogger(TestJMockData.class);


    @Test
    public void testGetSeq() {
        logger.info("Enter...");
        MockConfig mockConfig = new MockConfig();
        mockConfig.subConfig("age").intRange(16,35).globalConfig().dateRange("2021-06-01", "2021-09-01");
        SimpleDateFormat f = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < 10; i++) {
            System.out.println(f.format(JMockData.mock(Date.class, mockConfig)));
        }
    }

}
