package com.example.curso_springboot.controller;

import com.example.curso_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.curso_springboot.model.Produto;
import com.example.curso_springboot.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    private ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto>listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable long id){
            Produto produto = produtoService.buscarPorId(id);
            return ResponseEntity.ok(produto);

    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
