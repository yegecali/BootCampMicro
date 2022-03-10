package com.bootcamp.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.credit.entity.Operacion;

public interface OperacionRepository extends ReactiveMongoRepository<Operacion, String>{

}
