package com.targettrust.salao.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PessoaDTO {

    private long id;
    private String nome;
    private String sobrenome;
    private String cpf;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
