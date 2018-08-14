package com.intexsoft.shalkevich.helloQueue.controller;

import com.intexsoft.shalkevich.helloQueue.service.ProduceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Message controller for message sending
 * to rabbitmq
 */
@RestController
@Slf4j
public class ProduceController {
    private final ProduceService produceService;

    public ProduceController(ProduceService produceService) {
        this.produceService = produceService;
    }

    /**
     * Sends message into RabbitMQ
     *
     * @param msg message content
     * @return status string
     * @see ProduceService#produceMsg(String)
     */
    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg")String msg){
        produceService.produceMsg(msg);
        if(log.isDebugEnabled()) {
            log.debug("Debug message");
        }
        log.info("Invoked produceMsg(msg) by messageProducer");
        log.error("Error log message!");
        return "Done";
    }
}
