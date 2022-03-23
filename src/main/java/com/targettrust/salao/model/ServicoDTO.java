package com.targettrust.salao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ServicoDTO {

    private long id;
    private String descricao;
    private BigDecimal valor;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private List<ProdutoDTO> produtos;

    private List<ProfissionalDTO> profissionais;
}
