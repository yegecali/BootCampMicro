package com.bootcamp.credit.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Data
@Getter
@Setter
@NoArgsConstructor
public class Operacion {
	@Id
	private String id;
	private double monto;
	private Date fecha_operacion;
	private String idCredito;
	public Operacion(double monto, String idCredito) {
		this.monto = monto;
		this.idCredito = idCredito;
		this.fecha_operacion = new Date();
	}

}
