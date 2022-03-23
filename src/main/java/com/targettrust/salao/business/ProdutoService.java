package com.targettrust.salao.business;

import com.targettrust.salao.entity.Produto;
import com.targettrust.salao.model.ProdutoDTO;
import com.targettrust.salao.repository.ProdutoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public void deletar (Long id) {
        produtoDAO.deleteById(id);
    }

    public List<Produto> buscarDescricao (ProdutoDTO produtoDTO) {
        return produtoDAO.findByDescricao(produtoDTO.getDescricao());

    }

    public ProdutoDTO atualizar (ProdutoDTO produtoDTO, Long id) throws Exception {
        Produto prod = new Produto();

        Optional <Produto> produtoOpt = produtoDAO.findById(id);

        if (produtoOpt.isPresent() ) {
            prod = produtoOpt.get();
            prod.setDescricao(produtoDTO.getDescricao());
            produtoDAO.save(prod);
        } else {
            log.info("Not found");
            throw new Exception("Not Found");

        }
        return ProdutoMapper.instance.produtoToProdutoDTO(prod);
    }

    public List<ProdutoDTO> buscarProdutoDescricaoValor(ProdutoDTO produtoDTO) {
        return ProdutoMapper.instance.listProdutoToProdutoDTO(produtoDAO.findByDescricaoAndValorGreaterThan(produtoDTO.getDescricao(), produtoDTO.getValor()));
    }

    public ProdutoDTO buscarPorCodigo (String codigo) {
        return ProdutoMapper.instance.produtoToProdutoDTO(produtoDAO.findByCodigo(codigo));
    }

}
