package com.targettrust.salao.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProfissionalDTO {

    private long id;
    private String funcao;
    private BigDecimal comissao;
    private BigDecimal salario;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private PessoaDTO pessoaDTO;
}
