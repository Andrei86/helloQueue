package com.intexsoft.shalkevich.helloQueue.component;

import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import lombok.Setter;
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
@Setter
public class MessageProducer {

    @Autowired
    MQParameters mqValues;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchange;

    /**
     *
     * @param msg for rabbitmq
     */
    public void produceMsg(String msg){
        rabbitTemplate.convertAndSend(exchange.getName(), mqValues.getRoutKey(), msg);
        log.info("Send message {} to exchange", msg);
    }
}