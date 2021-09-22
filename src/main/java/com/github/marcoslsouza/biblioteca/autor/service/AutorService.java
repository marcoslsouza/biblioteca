package com.github.marcoslsouza.biblioteca.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcoslsouza.biblioteca.autor.map.AutorMapper;
import com.github.marcoslsouza.biblioteca.autor.repository.AutorRepositorio;

@Service
public class AutorService {

	// AutorMapper nao esta sendo gerenciado pelo spring, entao precisa instanciar
	private final static AutorMapper AUTOR_MAPPER = AutorMapper.INSTANCE;
	
	// Para facilitar os testes unitarios, o AutorRepositorio sera injetado no construtor, e assim teremos uma instancia
	// da classe AutorRepositorio aqui em AutorService.
	private AutorRepositorio autorRepositorio;

	@Autowired
	public AutorService(AutorRepositorio autorRepositorio) {
		
		this.autorRepositorio = autorRepositorio;
	}
	
	
}
