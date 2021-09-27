package com.github.marcoslsouza.biblioteca.autor.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.marcoslsouza.biblioteca.autor.builder.AutorDTOBuilder;
import com.github.marcoslsouza.biblioteca.autor.map.AutorMapper;
import com.github.marcoslsouza.biblioteca.autor.repository.AutorRepositorio;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTeste {
	
	private final AutorMapper autorMapper = AutorMapper.INSTANCE;

	@Mock
	private AutorRepositorio autorRepositorio;
	
	@InjectMocks
	private AutorService autorService;
	
	private AutorDTOBuilder autorDTOBuilder;
	
	@BeforeEach
	void setUp() {
		autorDTOBuilder = autorDTOBuilder.builder().build();
	}
}
