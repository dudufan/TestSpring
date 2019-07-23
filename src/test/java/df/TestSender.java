package df;

import df.activemq.ActiveMQUtil;
import df.activemq.MessageSender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSender {
    @Autowired
    private MessageSender producer;

    @Before
    public void checkServer() {
        ActiveMQUtil.checkServer();
    }

    @Test
    public void testSend(){
        for (int i = 0; i < 100; i++) {
            producer.sendMessage("消息 " + i);
        }
    }
}
