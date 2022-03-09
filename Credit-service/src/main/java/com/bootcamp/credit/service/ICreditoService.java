package com.bootcamp.credit.service;


import com.bootcamp.credit.entity.Credito;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditoService {
	
	Flux<Credito> findAll();
	Mono<Credito> findById(String id);
	Mono<Credito> save(Credito credit);
	Mono<Credito> update(Credito credit);
	Mono<Void> deleteById(String id);
	
	Mono<Credito> propietarioCredito(String idCredito);

}
