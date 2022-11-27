package com.example.subscriber;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BachelorStudentRepository extends CrudRepository<BachelorStudent, UUID> {

}
