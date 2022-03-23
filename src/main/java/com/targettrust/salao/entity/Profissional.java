package com.targettrust.salao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PROFISSIONAIS")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "FUNCAO")
    private String funcao;

    @NotNull
    @Column(name = "SALARIO")
    private BigDecimal salario;

    @NotNull
    @Column(name = "COMISSAO")
    private BigDecimal comissao;

    @CreatedDate
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoa;
}
