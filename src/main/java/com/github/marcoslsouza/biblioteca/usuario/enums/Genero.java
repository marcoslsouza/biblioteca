package com.github.marcoslsouza.biblioteca.usuario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {

	MASCULINO("MASCULINO"),
	FEMINIMO("FEMINIMO");
	
	private String description;
}
