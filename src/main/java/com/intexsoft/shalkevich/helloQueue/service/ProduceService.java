package com.intexsoft.shalkevich.helloQueue.service;

import com.intexsoft.shalkevich.helloQueue.model.BookMessage;
import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ messages producer
 */
@Service
@Log4j
@Getter
public class ProduceService implements IProduceService {

    private final MQParameters mqParameters;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public ProduceService(MQParameters mqValues, RabbitTemplate rabbitTemplate, DirectExchange exchange) {
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
    public void produceMsg(BookMessage msg) {
        log.info(String.format("Sent message %s to exchange.", msg));
        rabbitTemplate.convertAndSend(exchange.getName(), mqParameters.getRoutKeyTo(), msg);
    }
}