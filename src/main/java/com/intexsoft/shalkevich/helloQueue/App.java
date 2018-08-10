package com.intexsoft.shalkevich.helloQueue;

import com.intexsoft.shalkevich.helloQueue.component.MessageProducer;
import com.intexsoft.shalkevich.helloQueue.util.MQParameters;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    MQParameters mqValues;

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

    @Bean
    MessageProducer producer(){
        return new MessageProducer();
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(App.class, args);
    }
}
