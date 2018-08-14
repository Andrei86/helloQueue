package com.intexsoft.shalkevich.helloQueue.configuration;

import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Configuration for HelloRabbitApp
 */
@Configuration
public class HelloRabbitConf {
    private final MQParameters mqValues;

    public HelloRabbitConf(MQParameters mqValues) {
        this.mqValues = mqValues;
    }

    @Bean
    Queue queue() {
        return new Queue(mqValues.getQueueName(), true);
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(mqValues.getDirectExchangeName());
    }
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(mqValues.getRoutKey());
    }
}
