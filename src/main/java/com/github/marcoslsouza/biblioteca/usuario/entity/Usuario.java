package com.github.marcoslsouza.biblioteca.usuario.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.github.marcoslsouza.biblioteca.entity.Auditoria;
import com.github.marcoslsouza.biblioteca.livros.entity.Livros;
import com.github.marcoslsouza.biblioteca.usuario.enums.Genero;

import lombok.ToString;

@ToString
@Entity
public class Usuario extends Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(columnDefinition = "integer default 0")
	private int idade;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Genero genero;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDate dataAniversario;
	
	// FetchType.LAZY => nao traz os livros junto com o autor desnecessariamente.
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Livros> livros;
}
