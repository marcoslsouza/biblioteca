package com.github.marcoslsouza.biblioteca.autor.builder;

import com.github.marcoslsouza.biblioteca.autor.dto.AutorDTO;

import lombok.Builder;

@Builder
public class AutorDTOBuilder {
	
	@Builder.Default
	private final Long id = 1L;
	
	@Builder.Default
	private final String nome = "Marcos L.";
	
	@Builder.Default
	private final int idade = 40;
	
	public AutorDTO buildAutorDTO() {
		return new AutorDTO(id, nome, idade);
	}
}
