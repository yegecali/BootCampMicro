package com.bootcamp.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.person.entity.Persona;

public interface PersonRepository extends ReactiveMongoRepository<Persona, String>{

}
