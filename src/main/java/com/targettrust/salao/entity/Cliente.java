package com.targettrust.salao.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLIENTES")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "VALOR_GASTO")
    private BigDecimal valorGasto;

    @Column(name = "DATA_CRIACAO")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoa;
}
