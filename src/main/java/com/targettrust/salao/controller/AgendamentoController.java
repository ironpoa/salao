package com.targettrust.salao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class AgendamentoController {

    @RequestMapping("/consulta")
    @GetMapping("/agendamento/profissional")
    public Optional buscarAgendamentoProfissional(String nome, String data) {
        log.info("Buscando agendamento de: " +nome + " para o dia " +data);
        return Optional.empty();
    }
}
