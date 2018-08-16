package by.intexsoft.shalkevich.queueExample.controller;

import by.intexsoft.shalkevich.queueExample.service.BookConsumeFromCassandraService;
import by.intexsoft.shalkevich.queueExample.service.ProduceService;
import by.intexsoft.shalkevich.queueExample.model.BookMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Message controller for sending messages to RabbitMQ
 */
@RestController
@Log4j2
@RequiredArgsConstructor
public class ProduceController {
    private final ProduceService produceService;
    private final BookConsumeFromCassandraService bookConsumeFromCassandraService;
    /**
     * Sends message into RabbitMQ
     * @param title book title
     * @return message of book creating
     * @see ProduceService#produceMessage(BookMessage)
     */
    @RequestMapping("/send/book")
    public String sendMessage(@RequestParam("title")String title) throws InterruptedException {
        produceService.produceMessage(new BookMessage(title));
        log.info("Invoked produceMessage(msg) method by messageProducer.");
        Thread.sleep(1000);
        return "Book " + bookConsumeFromCassandraService.getMessageBody() + " created.";
    }
}
