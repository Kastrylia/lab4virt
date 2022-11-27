package com.example.subscriber;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MasterStudentRepository extends CrudRepository<MasterStudent, UUID> {

}
