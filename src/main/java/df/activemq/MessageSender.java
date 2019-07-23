package df.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(String message) {
		Destination destination = new ActiveMQTopic("mytopic1");
		jmsTemplate.convertAndSend(destination, message);
	}

	// ...

}