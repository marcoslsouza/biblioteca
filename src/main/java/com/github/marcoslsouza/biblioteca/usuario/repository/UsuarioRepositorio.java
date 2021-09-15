package com.github.marcoslsouza.biblioteca.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.marcoslsouza.biblioteca.usuario.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
