package com.intexsoft.shalkevich.helloQueue.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author andrey.shalkevich on 10.08.2018;
 *
 * Storage for rabbitmq parameters
 */
@Component
@Getter
public class MQParameters {
    @Value("${hello.rabbitmq.queue}")
    String queueName;

    @Value("${hello.rabbitmq.exchange}")
    String directExchangeName;

    @Value("${hello.rabbitmq.routing.key}")
    String routKey;
}
