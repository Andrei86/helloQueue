package com.intexsoft.shalkevich.helloQueue.configuration;

import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for HelloRabbitApp
 */
@Configuration
public class HelloRabbitConf {
    private final MQParameters mqParameters;

    /**
     * Constructor for adding parameters for RabbitMQ settings
     *
     * @param mqParameters object for RabbitMQ settings storage
     */
    public HelloRabbitConf(MQParameters mqParameters) {
        this.mqParameters = mqParameters;
    }

    @Bean
    Queue queueTo() {
        return new Queue(mqParameters.getQueueToCassandra(), true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(mqParameters.getDirectExchangeName());
    }

    @Bean
    Binding binding(Queue queueToCassandra, DirectExchange exchange) {
        return BindingBuilder.bind(queueToCassandra).to(exchange).with(mqParameters.getRoutKeyTo());
    }

    @Bean
    MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
