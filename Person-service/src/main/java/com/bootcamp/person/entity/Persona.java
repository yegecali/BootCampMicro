package com.bootcamp.person.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Document(collection = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	private String id;
	private String nombre;
	private String tipo; // personal or business
}
