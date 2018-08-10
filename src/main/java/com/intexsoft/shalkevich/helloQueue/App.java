package com.intexsoft.shalkevich.helloQueue;

import com.intexsoft.shalkevich.helloQueue.component.MessageProducer;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @author andrey.shalkevich on 10.08.2018;
 *
 * Class for running application for
 * adding messages to rabbitmq queue
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class App
{
    @Value("${hello.rabbitmq.queue}")
    String queueName;

    @Value("${hello.rabbitmq.exchange}")
    String directExchangeName;

    @Value("${hello.rabbitmq.routing.key}")
    String routKey;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routKey);
    }

    @Bean
    MessageProducer producer(){
        return new MessageProducer(routKey);
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(App.class, args);
    }
}
