package by.intexsoft.shalkevich.queueExample.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for RabbitExampleApplication
 */
@Configuration
@ComponentScan(basePackages = "by.intexsoft.shalkevich.queueExample.configuration")
public class ApplicationConfiguration {
    @Autowired
    private BasicConfigurationProperties basicConfigurationProperties;

    @Bean
    Queue queueToCassandra() {
        return new Queue(basicConfigurationProperties.getQueueNameToCassandra(), true);
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(basicConfigurationProperties.getExchangeName());
    }
    @Bean
    Binding binding(Queue queueToCassandra, DirectExchange exchange) {
        return BindingBuilder.bind(queueToCassandra).to(exchange).with(basicConfigurationProperties.getRoutKey());
    }
    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
