package com.bootcamp.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.credit.entity.Credito;

public interface CreditoRepository extends ReactiveMongoRepository<Credito, String>{
	
}
