package ru.innopolis.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PublisherService {
    private final AmqpTemplate template;

    @Value("${rabbitQueue}")
    private String rabbitQueue;

    public PublisherService(AmqpTemplate template) {
        this.template = template;
    }

    public ResponseEntity<String> publish() {
        UUID studentId = UUID.randomUUID();
        String message = generateGroupNumber() + ":" + studentId;
        template.convertAndSend(rabbitQueue, message);
        System.out.println("Generated student: " + message);
        return ResponseEntity.ok(message);
    }

    private String generateGroupNumber() {
        int groupNumber = (int) (Math.random() * 6);
        return switch (groupNumber) {
            // First bachelor year
            case 0 -> "B23";
            // Second bachelor year
            case 1 -> "B22";
            // Third bachelor year
            case 2 -> "B20";
            // Fourth bachelor year
            case 3 -> "B19";
            // First master year
            case 4 -> "MS22";
            // Second master year
            default -> "MS21";
        };
    }
}
