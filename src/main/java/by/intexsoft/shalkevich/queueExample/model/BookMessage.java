package by.intexsoft.shalkevich.queueExample.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/**
 * Model for message for book creating
 */
@RequiredArgsConstructor
@Getter
public class BookMessage {
    private final String title;
    /**
     * Describes string performance of {@link BookMessage}
     * @return string performance of {@link BookMessage} instance
     */
    @Override
    public String toString() {
        return "title = " + title;
    }
}
