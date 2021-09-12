package com.github.marcoslsouza.biblioteca.livros.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.github.marcoslsouza.biblioteca.autor.entity.Autor;
import com.github.marcoslsouza.biblioteca.editora.entity.Editora;
import com.github.marcoslsouza.biblioteca.entity.Auditable;
import com.github.marcoslsouza.biblioteca.usuario.entity.Usuario;

import lombok.ToString;

@ToString
@Entity
public class Livros extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(columnDefinition = "integer default 0")
	private int pages;
	
	@Column(columnDefinition = "integer default 0")
	private int capitulos;
	
	// Ex: Na tela que cadastra um livro teremos a opcao de selecionar o autor, ou seja cascade apenas para atualizar com os dados do autor, nao
	// sendo obrigatorio cascade na exclusao, insercao...
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Autor autor;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Editora editora;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Usuario usuario;
}
