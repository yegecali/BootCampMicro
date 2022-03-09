package com.bootcamp.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.person.entity.Persona;
import com.bootcamp.person.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonRepository _repo;
	
	@Override
	public Flux<Persona> findAll() {
		return _repo.findAll();
	}

	@Override
	public Mono<Persona> save(Persona person) {
		 return _repo.save(person);
	}

	@Override
	public Flux<Persona> findPersonal() {
		return _repo.findAll().filter(x -> x.getTipo().equals("personal"));
	}

	@Override
	public Flux<Persona> findBusiness() {
		return _repo.findAll().filter(x -> x.getTipo().equals("business"));
	}

}
