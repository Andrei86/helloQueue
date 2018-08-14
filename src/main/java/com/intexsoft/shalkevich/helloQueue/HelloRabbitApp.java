package com.intexsoft.shalkevich.helloQueue;

import com.intexsoft.shalkevich.helloQueue.configuration.HelloRabbitConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Class for running application for
 * adding messages to rabbitmq queue
 */
@SpringBootApplication
@Import(HelloRabbitConf.class)
@PropertySource("classpath:application.properties")
public class HelloRabbitApp
{
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(HelloRabbitApp.class, args);
    }
}
