package com.github.marcoslsouza.biblioteca.autor.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotacoes Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
	
	private Long id;
	
	// Anotacoes beanValidation
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String nome;
	
	@NotNull
	@Max(120) // Referente a numeros
	private int idade;
}
