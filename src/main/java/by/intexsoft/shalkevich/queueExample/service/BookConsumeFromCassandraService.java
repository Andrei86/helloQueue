package by.intexsoft.shalkevich.queueExample.service;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
/**
 * Consumes messages from fromCassandra queue
 */
@Service
@Log4j2
@Getter
public class BookConsumeFromCassandraService implements MessageListener {
    private String messageBody;
    /**
     * Initializes the message body from SpringCassandra application
     * @param message from fromCassandra queue
     */
    @Override
    public void onMessage(Message message) {
        messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
    }
}
