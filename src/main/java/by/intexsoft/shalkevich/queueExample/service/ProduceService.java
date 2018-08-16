package by.intexsoft.shalkevich.queueExample.service;

import by.intexsoft.shalkevich.queueExample.model.BookMessage;
import by.intexsoft.shalkevich.queueExample.configuration.BasicConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
/**
 * RabbitMQ messages producer
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ProduceService implements IProduceService {
    private final BasicConfigurationProperties basicConfigurationProperties;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;
    /**
     * Sends messages into RabbitMq queue
     * @param message for rabbitmq
     * @see RabbitTemplate#convertAndSend(String, String, Object)
     */
    public void produceMessage(BookMessage message) {
        log.info(String.format("Sent message %s to exchange.", message));
        rabbitTemplate.convertAndSend(exchange.getName(), basicConfigurationProperties.getRoutKeyToCassandra(), message);
    }
}