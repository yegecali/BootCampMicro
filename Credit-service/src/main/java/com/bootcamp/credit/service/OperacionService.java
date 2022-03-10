package com.bootcamp.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.credit.entity.Operacion;
import com.bootcamp.credit.repository.CreditoRepository;
import com.bootcamp.credit.repository.OperacionRepository;

import reactor.core.publisher.Mono;
@Service
public class OperacionService implements IOperacionService{

	@Autowired
	private CreditoRepository _creditoRepo;
	@Autowired
	private OperacionRepository _operacionRepo;
	
	@Override
	public Mono<Operacion> RealizarOperacion(Operacion op) {
		return _operacionRepo.save(op).filter(null);
	}

	@Override
	public Mono<Operacion> save(Operacion op) {
		return _operacionRepo.save(op);
	}

}
