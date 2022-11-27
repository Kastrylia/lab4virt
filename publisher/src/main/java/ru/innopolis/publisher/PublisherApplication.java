package ru.innopolis.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PublisherApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PublisherApplication.class, args);
        new Thread(() -> {
            try {
                while (true) {
                    ((PublisherService) context.getBean("publisherService")).publish();
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }
}
