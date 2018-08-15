package by.intexsoft.shalkevich.queueExample.model;
import lombok.Getter;
import lombok.Setter;
/**
 * Model for message for book creating
 */
@Setter
@Getter
public class BookMessage {
    private String title;

    /**
     * Create {@link BookMessage} instance
     * @param title of {@link java.awt.print.Book}
     */
    public BookMessage(String title) {
        this.title = title;
    }
    /**
     * Describe string performance of {@link BookMessage}
     * @return string performance of {@link BookMessage} instance
     */
    @Override
    public String toString() {
        return "title = " + title;
    }
}
