package com.targettrust.salao.business;

import com.targettrust.salao.entity.Produto;
import com.targettrust.salao.model.ProdutoDTO;
import com.targettrust.salao.repository.ProdutoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProdutoService {

    @Autowired
    ProdutoDao produtoDAO;

    public Optional<Produto> buscarProduto (Long id) {
        return produtoDAO.findById(id);
    }

    public List<Produto> buscarProdutos () {
        return produtoDAO.findAll();
    }

    public Produto salvar (ProdutoDTO produtoDTO) {
        return produtoDAO.save(ProdutoMapper.instance.produtoDtoToProduto(produtoDTO));
    }

    public void deletar (ProdutoDTO produtoDTO) {
        buscarDescricao(produtoDTO).stream().forEach(prod -> produtoDAO.delete(prod));
    }

    public List<Produto> buscarDescricao (ProdutoDTO produtoDTO) {
        return produtoDAO.findByDescricao(produtoDTO.getDescricao());

    }

    public Produto atualizar () {
        return null;
    }
}
