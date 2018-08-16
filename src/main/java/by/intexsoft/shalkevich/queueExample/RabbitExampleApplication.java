package by.intexsoft.shalkevich.queueExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Class for application running
 */
@SpringBootApplication
public class RabbitExampleApplication
{
    /**
     * Method for application starting
     * @param args fo start application
     */
    public static void main(String[] args) {
        SpringApplication.run(RabbitExampleApplication.class, args);
    }
}
