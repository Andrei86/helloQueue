package by.intexsoft.shalkevich.queueExample.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
/**
 * Storage for RabbitMQ configuration properties
 */
@Getter
public class BasicConfigurationProperties {
    @Value("${queue.rabbitmq.host}")
    String rabbitMQHostname;

    @Value("${queue.rabbitmq.port}")
    Integer rabbitMQPort;

    @Value("${queue.rabbitmq.username}")
    String rabbitMQUsername;

    @Value("${queue.rabbitmq.password}")
    String rabbitMQPassword;

    @Value("${queue.name.produce.to.cassandra}")
    String queueNameToCassandra;

    @Value("${queue.name.receive.from.cassandra}")
    String queueNameFromCassandra;

    @Value("${queue.exchange}")
    String exchangeName;

    @Value("${queue.routing.key.produce.to.cassandra}")
    String routKeyToCassandra;

    @Value("${queue.routing.key.from.cassandra}")
    String routKeyFromCassandra;
}
