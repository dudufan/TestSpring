package df.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@Autowired(required = false)
	JmsTemplate jmsTemplate;

//	@JmsListener(destination = "mytopic", containerFactory = "topicJmsListenerContainerFactory")
//	@JmsListener(destination = "mytopic1", containerFactory = "myFactory")
	public void processMessage(String content) {
		System.out.println("收到 " + content);
	}

}