package com.intexsoft.shalkevich.helloQueue.controller;
import com.intexsoft.shalkevich.helloQueue.model.BookMessage;
import com.intexsoft.shalkevich.helloQueue.service.ProduceService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * Message controller for message sending
 * to RabbitMQ
 */
@RestController
@Log4j
public class ProduceController {
    private final ProduceService produceService;
    public ProduceController(ProduceService produceService) {
        this.produceService = produceService;
    }
    /**
     * Sends message into RabbitMQ
     *
     * @param title book title
     * @return status string
     * @see ProduceService#produceMsg(BookMessage)
     */
    @RequestMapping("/send/book")
    public String sendMsg(@RequestParam("title")String title){
        BookMessage bookMessage = new BookMessage(title);
        produceService.produceMsg(bookMessage);
        log.info(String.format("Invoked produceMsg(msg) by messageProducer with message %s.", bookMessage));
        return "Done";
    }
}
