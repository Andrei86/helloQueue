package by.intexsoft.shalkevich.queueExample.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for RabbitExampleApplication
 */
@Configuration
public class ApplicationConfiguration {
    private final BasicConfigurationProperties basicConfigurationProperties;

    /**
     * Constructor for adding parameters for RabbitMQ settings
     *
     * @param basicConfigurationProperties object for RabbitMQ basic configuration properties storage
     */
    public ApplicationConfiguration(BasicConfigurationProperties basicConfigurationProperties) {
        this.basicConfigurationProperties = basicConfigurationProperties;
    }

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
