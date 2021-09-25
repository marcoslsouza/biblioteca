package com.github.marcoslsouza.biblioteca.autor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.marcoslsouza.biblioteca.autor.service.AutorService;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController implements AutorControllerDocs {

	private AutorService autorService;

	@SuppressWarnings("all")
	@Autowired
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	
}
