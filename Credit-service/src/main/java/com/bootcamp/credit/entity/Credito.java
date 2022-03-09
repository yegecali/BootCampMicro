package com.bootcamp.credit.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Document(collection="Credito")
public class Credito{
	@Id
	private String id;
	private String tipo;
	private float saldo;
	private float limiteCredito;
	private List<String> idPersonas;
	public Credito(String id, String tipo, float limiteCredito) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.limiteCredito = limiteCredito;
		this.saldo = this.limiteCredito;
		this.idPersonas = new ArrayList<String>();
	}
	
	
	
}
