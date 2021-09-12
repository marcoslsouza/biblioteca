package com.github.marcoslsouza.biblioteca.editora.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.github.marcoslsouza.biblioteca.entity.Auditable;
import com.github.marcoslsouza.biblioteca.livros.entity.Livros;

import lombok.ToString;

@ToString
@Entity
public class Editora extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, unique = true, length = 100)
	private String codigo;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDate dataFundacao;
	
	// FetchType.LAZY => nao traz os livros junto com o autor desnecessariamente.
	@OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
	private List<Livros> livros;
}
