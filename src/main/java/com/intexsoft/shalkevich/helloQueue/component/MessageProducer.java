package com.intexsoft.shalkevich.helloQueue.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Component;

/**
 * @author andrey.shalkevich on 10.08.2018;
 *
 * Class for rabbitmq messages producing
 */
@Component
@Log4j2
public class MessageProducer {

    private String routKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchange;

    /**
     *
     * @param routKey as routing key for messages producing
     */
    public MessageProducer(String routKey){
        this.routKey = routKey;
    }

    /**
     *
     * @param msg for rabbitmq
     */
    public void produceMsg(String msg){
        rabbitTemplate.convertAndSend(exchange.getName(), routKey, msg);
        log.info("Send message {} to exchange", msg);
    }
}