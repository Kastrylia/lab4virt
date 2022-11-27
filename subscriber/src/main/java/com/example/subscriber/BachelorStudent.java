package com.example.subscriber;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "bachelors")
public class BachelorStudent {
    @Id
    @Column(name = "student_id")
    UUID studentId;

    @Column(name = "group_number")
    String groupNumber;
}
