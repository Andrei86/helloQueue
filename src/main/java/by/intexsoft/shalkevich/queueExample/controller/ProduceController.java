package by.intexsoft.shalkevich.queueExample.controller;
import by.intexsoft.shalkevich.queueExample.service.ProduceService;
import by.intexsoft.shalkevich.queueExample.model.BookMessage;
import by.intexsoft.shalkevich.queueExample.util.ApplicationConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Message controller for sending messages to RabbitMQ
 */
@RestController
@Log4j2
public class ProduceController {
    private final ProduceService produceService;
    /**
     * Create {@link ProduceController} instance
     * @param produceService bean for {@link ProduceController}s use
     */
    public ProduceController(ProduceService produceService) {
        this.produceService = produceService;
    }
    /**
     * Sends message into RabbitMQ
     * @param title book title
     * @return ApplicationConstants.DONE_STATUS
     * @see ProduceService#produceMessage(BookMessage)
     */
    @RequestMapping("/send/book")
    public String sendMessage(@RequestParam("title")String title){
        produceService.produceMessage(new BookMessage(title));
        log.info("Invoked produceMessage(msg) method by messageProducer.");
        return ApplicationConstants.DONE_STATUS;
    }
}
