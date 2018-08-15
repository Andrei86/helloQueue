package by.intexsoft.shalkevich.queueExample.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 *
 * Storage for configuration properties
 */
@Component
@Getter
public class BasicConfigurationProperties {
    @Value("${queue.name.produce.to.cassandra}")
    String queueNameToCassandra;

    @Value("${queue.exchange}")
    String exchangeName;

    @Value("${queue.routing.key.produce.to.cassandra}")
    String routKey;
}
