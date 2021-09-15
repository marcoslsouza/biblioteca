package com.github.marcoslsouza.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.marcoslsouza.biblioteca.livros.entity.Livros;

public interface LivrosRepositorios extends JpaRepository<Livros, Long> {

}
