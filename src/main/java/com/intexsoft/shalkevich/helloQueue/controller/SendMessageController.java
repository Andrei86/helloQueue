package com.intexsoft.shalkevich.helloQueue.controller;

import com.intexsoft.shalkevich.helloQueue.component.MessageProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrey.shalkevich on 10.08.2018;
 *
 * Message controller for messages sending
 * to rabbitmq
 */
@RestController
@Log4j2
public class SendMessageController {
    @Autowired
    MessageProducer messageProducer;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg")String msg){
        messageProducer.produceMsg(msg);
        return "Done";
    }
}
