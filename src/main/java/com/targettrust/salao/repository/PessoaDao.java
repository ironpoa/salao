package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long> {

    @Query (value = "SELECT * from salao.pessoas where nome = ?1 and sobrenome = ?2 and CPF like ?3% ", nativeQuery = true)
    List<Pessoa> buscarPessoasPorNomeSobrenomeCpf(String nome, String sobrenome, String cpf);

}
