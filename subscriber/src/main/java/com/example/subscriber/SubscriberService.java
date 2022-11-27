package com.example.subscriber;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@EnableRabbit
@Component
public class SubscriberService {

    @Autowired
    private MasterStudentRepository masterStudentRepository;

    @Autowired
    private BachelorStudentRepository bachelorStudentRepository;

    @RabbitListener(queues = "${rabbitQueue}")
    public void receiveMessage(String message) {
        System.out.println(message);
        String[] fsd = message.split(":");
        String groupNumber = fsd[0];
        UUID studentId = UUID.fromString(fsd[1]);

        if (groupNumber.contains("B")) {
            BachelorStudent student = new BachelorStudent();
            student.studentId = studentId;
            student.groupNumber = groupNumber;
            bachelorStudentRepository.save(student);
        } else {
            MasterStudent student = new MasterStudent();
            student.studentId = studentId;
            student.groupNumber = groupNumber;
            masterStudentRepository.save(student);
        }
    }
}
