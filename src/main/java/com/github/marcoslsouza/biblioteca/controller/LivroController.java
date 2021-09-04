package com.github.marcoslsouza.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
// Primeira versao da API
@RequestMapping("/api/v1/livros")
public class LivroController {
	
	// Descricao do que o metodo faz (sera exibido no swagger)
	@ApiOperation(value = "Retorna um exemplo hello world")
	// O status e a mensagem que o end point retorna (sera exibido no swagger)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Success method return")
	})
	@GetMapping
	public String hello() {
		return "Olá Biblioteca de livros!";
	}

}
