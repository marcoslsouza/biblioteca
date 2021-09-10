package com.github.marcoslsouza.biblioteca.autor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.github.marcoslsouza.biblioteca.livros.entity.Livros;

import lombok.Data;

@Data
@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(columnDefinition = "integer default 0")
	private int idade;
	
	// FetchType.LAZY => nao traz os livros junto com o autor desnecessariamente.
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
	private List<Livros> livros;
}