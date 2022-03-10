package com.bootcamp.person.service;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.person.entity.Persona;
import com.bootcamp.person.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

	private Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository _repo;
	
	@Override
	public Flux<Persona> findAll() {
		logger.info("ejecutando el servicio persona find all");
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

	@Override
	public Mono<Persona> update(Persona person) {
		 return _repo.save(person);
	}

	@Override
	public void deleteById(String id) {
		_repo.deleteById(id).subscribe();
		
	}

	@Override
	public Mono<Persona> findById(String id) {
		return _repo.findById(id);
	}

}
