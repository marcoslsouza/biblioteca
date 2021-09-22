package com.github.marcoslsouza.biblioteca.autor.map;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.marcoslsouza.biblioteca.autor.dto.AutorDTO;
import com.github.marcoslsouza.biblioteca.autor.entity.Autor;

@Mapper
public interface AutorMapper { //NOSONAR

	// Como nao sera um objeto do Spring, criaremos uma constante para ser acessada pelas outras classes do projeto.
	AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);
	
	Autor toModel(AutorDTO autorDTO);
	
	AutorDTO toDTO(Autor autor);
}
