package com.github.marcoslsouza.biblioteca.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// Classe mapeada que pode ser extendida por qualquer uma das entidades do projeto
@MappedSuperclass

// Toda vez que é inserida uma data será salvada uma auditoria
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditoria {

	@CreatedDate
	@Column(name = "DATA_CRIACAO", nullable = false)
	protected LocalDateTime createdDate;
	
	@LastModifiedDate
	@Column(name = "DATA_ULTIMA_MODIFICACAO")
	protected LocalDateTime lastModifiedDate;
}
