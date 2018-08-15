package by.intexsoft.shalkevich.queueExample.service;

import by.intexsoft.shalkevich.queueExample.model.BookMessage;

/**
 * Describes BookMessage producer
 */
public interface IProduceService {
    /**
     * Describes message producing
     * @param message of {@link BookMessage}
     */
    void produceMessage(BookMessage message);
}
