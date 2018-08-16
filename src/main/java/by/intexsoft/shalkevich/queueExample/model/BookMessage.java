package by.intexsoft.shalkevich.queueExample.model;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Model for message for book creating
 */
@RequiredArgsConstructor
@Getter
public class BookMessage {
    @NonNull
    private String title;
    /**
     * Describes string performance of {@link BookMessage}
     * @return string performance of {@link BookMessage} instance
     */
    @Override
    public String toString() {
        return "title = " + title;
    }
}
