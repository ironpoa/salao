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
@Table (name = "PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotNull
    @Column(name = "CODIGO", unique = true)
    private String codigo;

    @CreatedDate
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICO_ID")
    private Servico servico;
}
