package com.bootcamp.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.person.entity.Persona;
import com.bootcamp.person.repository.PersonRepository;
import com.bootcamp.person.service.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	@Autowired
	private IPersonService _service;
	
	@PostMapping
	public Mono<Persona> addPerson(@RequestBody Persona person){
		return _service.save(person);
	}
	@PutMapping
	public Mono<Persona> updatePerson(@RequestBody Persona person){
		return _service.update(person);
	}
	@GetMapping
	public Flux<Persona> getPersons(){
		return _service.findAll();
	}
	@GetMapping("/{id}")
	public Mono<Persona> getPersons(@PathVariable("id") String id){
		return _service.findById(id);
	}
	@GetMapping("/personal")
	public Flux<Persona> getPersonPersonal(){
		return _service.findPersonal();
	}
	@GetMapping("/business")
	public Flux<Persona> getPersonBusiness(){
		return _service.findBusiness();
	}
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable("id") String id) {
		_service.deleteById(id);
		
	}
}
