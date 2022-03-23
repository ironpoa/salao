package com.targettrust.salao.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ClienteDTO {

    private long id;
    private BigDecimal valorGasto;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private PessoaDTO pessoaDTO;

}
