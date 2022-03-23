package com.targettrust.salao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SERVICOS")
public class Servico {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUTO_ID")
    private List<Produto> produtos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AGENDAMENTO", joinColumns = @JoinColumn(name = "SERVICO_ID"),
        inverseJoinColumns = @JoinColumn(name = "PROFISSIONAL_ID"))
    private List<Profissional> profissionais;
}
