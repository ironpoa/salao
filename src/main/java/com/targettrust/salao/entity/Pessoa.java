package com.targettrust.salao.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "PESSOAS")
@Entity
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @NotNull
    @Column(name = "CPF")
    private String cpf;

    @Column(name = "DATA_CRIACAO")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;


    public Pessoa() {
    }

    public Pessoa(Object o) {
    }
}
