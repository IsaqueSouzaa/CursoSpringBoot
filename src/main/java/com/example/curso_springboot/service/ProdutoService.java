package com.example.curso_springboot.service;

import com.example.curso_springboot.model.Produto;
import com.example.curso_springboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(long id){
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id){
        produtoRepository.deleteAllById(Collections.singleton(id));
    }
}
