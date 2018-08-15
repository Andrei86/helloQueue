package com.intexsoft.shalkevich.helloQueue.service;

import com.intexsoft.shalkevich.helloQueue.model.BookMessage;

/**
 * Describes BookMessage producer
 */
public interface IProduceService {

    /**
     *
     * @param message with book title
     */
    void produceMsg(BookMessage message);
}
