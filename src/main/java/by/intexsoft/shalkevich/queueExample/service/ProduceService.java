package by.intexsoft.shalkevich.queueExample.service;

import by.intexsoft.shalkevich.queueExample.model.BookMessage;
import by.intexsoft.shalkevich.queueExample.configuration.BasicConfigurationProperties;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
/**
 * RabbitMQ messages producer
 */
@Service
@Log4j2
@Getter
public class ProduceService implements IProduceService {

    private final BasicConfigurationProperties mqParameters;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public ProduceService(BasicConfigurationProperties mqValues, RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.mqParameters = mqValues;
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }
    /**
     * Sends messages into RabbitMq queue
     *
     * @param msg for rabbitmq
     * @see RabbitTemplate#convertAndSend(String, String, Object)
     */
    public void produceMessage(BookMessage msg) {
        log.info(String.format("Sent message %s to exchange.", msg));
        rabbitTemplate.convertAndSend(exchange.getName(), mqParameters.getRoutKey(), msg);
    }
}