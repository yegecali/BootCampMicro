package com.bootcamp.person.service;

import com.bootcamp.person.entity.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

	Flux<Persona> findAll();
	Mono<Persona> findById(String id);
	Mono<Persona> save(Persona person);
	Flux<Persona> findPersonal();
	Flux<Persona> findBusiness();
	Mono<Persona> update(Persona person);
	void deleteById(String id);
	
}
