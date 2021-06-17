package micro.usuario.producer;

import micro.usuario.model.Usuario;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;


public class EventSenderMessage {

	@Autowired
	private AmqpTemplate rabbitTemp;

	@Autowired
	private TopicExchange topicExchange;

	public EventSenderMessage() {}

	public void sendMessageRollback(Usuario usuario) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"rollback.usuario", usuario);
	}
}

