package com.github.marcoslsouza.biblioteca.autor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.marcoslsouza.biblioteca.autor.entity.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

}
