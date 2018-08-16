package by.intexsoft.shalkevich.queueExample.configuration;

import by.intexsoft.shalkevich.queueExample.service.BookConsumeFromCassandraService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration for RabbitExampleApplication
 */
@Configuration
public class ApplicationConfiguration extends BasicConfigurationProperties {
    @Bean
    ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new CachingConnectionFactory(getRabbitMQHostname(), getRabbitMQPort());
        ((CachingConnectionFactory) connectionFactory).setUsername(getRabbitMQUsername());
        ((CachingConnectionFactory) connectionFactory).setPassword(getRabbitMQPassword());
        return connectionFactory;
    }

    @Bean
    Queue queueToCassandra() {
        return new Queue(getQueueNameToCassandra(), true);
    }

    @Bean
    Queue queueFromCassandra() {
        return new Queue(getQueueNameFromCassandra(), true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(getExchangeName());
    }

    @Bean
    Binding binding(Queue queueFromCassandra, DirectExchange exchange) {
        return BindingBuilder.bind(queueFromCassandra).to(exchange).with(getRoutKeyFromCassandra());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, @Autowired MessageConverter messageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(final ConnectionFactory connectionFactory,
                                                            @Autowired MessageConverter messageConverter,
                                                            @Autowired BookConsumeFromCassandraService bookConsumeFromCassandraService) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setQueues(queueFromCassandra());
        listenerContainer.setMessageConverter(messageConverter);
        listenerContainer.setMessageListener(bookConsumeFromCassandraService);
        listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return listenerContainer;
    }
}
