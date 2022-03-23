package com.targettrust.salao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class ProdutoDTO {

    private long id;
    private String descricao;
    private BigDecimal valor;
    private String codigo;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private ServicoDTO servicoDTO;
}
