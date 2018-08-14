package com.intexsoft.shalkevich.helloQueue.service;

import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Rabbitmq messages producing
 */
@Service
@Slf4j
@Setter
public class ProduceService implements IProduceService {

    private final MQParameters mqValues;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public ProduceService(MQParameters mqValues, RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.mqValues = mqValues;
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    /**
     * Sends messages into rabbitMq queue
     *
     * @param msg for rabbitmq
     * @see RabbitTemplate#convertAndSend(String, String, Object)
     */
    public void produceMsg(String msg) {
        rabbitTemplate.convertAndSend(exchange.getName(), mqValues.getRoutKey(), msg);
        log.info("Sent message {} to exchange", msg);
    }
}