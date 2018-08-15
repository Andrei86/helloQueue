package com.intexsoft.shalkevich.helloQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Class for running application for
 * adding messages into Rabbitmq queue
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class HelloRabbitApp
{
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(HelloRabbitApp.class, args);
    }
}
