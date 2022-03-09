package com.bootcamp.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.credit.entity.Credito;
import com.bootcamp.credit.repository.CreditoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditoService implements ICreditoService{

	
	@Autowired
	private CreditoRepository _repoCredito; 
	
	@Override
	public Flux<Credito> findAll() {
		return _repoCredito.findAll();
	}

	@Override
	public Mono<Credito> findById(String id) {
		return _repoCredito.findById(id);
	}

	@Override
	public Mono<Credito> save(Credito credit) { 
		return  _repoCredito.save(credit);
	}

	@Override
	public Mono<Credito> update(Credito credit) {
		return  _repoCredito.save(credit);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _repoCredito.deleteById(id);
	}

	@Override
	public Mono<Credito> propietarioCredito(String idCredito) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
