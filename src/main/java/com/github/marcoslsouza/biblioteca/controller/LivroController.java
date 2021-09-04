package com.github.marcoslsouza.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Primeira versao da API
@RequestMapping("/api/v1/livros")
public class LivroController {
	
	@GetMapping
	public String hello() {
		return "Olá Biblioteca de livros!";
	}

}
