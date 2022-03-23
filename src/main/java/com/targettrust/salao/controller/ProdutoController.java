package com.targettrust.salao.controller;

import com.targettrust.salao.business.ProdutoMapper;
import com.targettrust.salao.business.ProdutoService;
import com.targettrust.salao.entity.Produto;
import com.targettrust.salao.model.ProdutoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@Slf4j
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder builder) {
        log.info("Entrando no ProdutoController.salvar");

        Produto produto = produtoService.salvar(produtoDTO);

        log.info("Produto cadastrada com sucesso.");
        URI uri = builder.path("/produto/cadastrar/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(ProdutoMapper.instance.produtoToProdutoDTO(produto));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable("id") long id) {
        log.info("Entrando no ProdutoController.buscarProduto");

        Optional<Produto> produto = produtoService.buscarProduto(id);

        log.info("Retornou a Produto");
        if (produto.isPresent()) {
            return new ResponseEntity<ProdutoDTO>(ProdutoMapper.instance.produtoToProdutoDTO(produto.get()), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> buscarProdutos() {
        return ProdutoMapper.instance.listProdutoToProdutoDTO(produtoService.buscarProdutos());
    }

    @GetMapping("/produtos/buscarProdutoNomeValor")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutoDescricaoValor(@RequestBody ProdutoDTO produtoDTO) {

        List<ProdutoDTO> produtos = produtoService.buscarProdutoDescricaoValor(produtoDTO);
        if (!produtos.isEmpty()) {
            return new ResponseEntity<List<ProdutoDTO>>(produtos, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/produtos/atualizar/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@RequestBody ProdutoDTO produtoDTO, @PathVariable Long id, UriComponentsBuilder builder) throws Exception {
        ProdutoDTO prodDto = produtoService.atualizar(produtoDTO, id);

        URI uri = builder.path("/produto/atualizar/{id}").buildAndExpand(prodDto.getId()).toUri();

        return ResponseEntity.created(uri).body(prodDto);
    }
    @GetMapping("/produtos/buscarPorCodigo")
    public ResponseEntity<ProdutoDTO> buscarPorCodigo(@RequestBody ProdutoDTO produtoDTO) {

        ProdutoDTO produto = produtoService.buscarPorCodigo(produtoDTO.getCodigo());
        if (!isNull(produto)) {
            return new ResponseEntity<ProdutoDTO>(produto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/produto/deletar/{id}")
    public ResponseEntity deletar (@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
