package com.bootcamp.credit.service;

import com.bootcamp.credit.entity.Operacion;

import reactor.core.publisher.Mono;

public interface IOperacionService{
	
	Mono<Operacion> save(Operacion op);
	Mono<Operacion> RealizarOperacion(Operacion op);
	
	
}