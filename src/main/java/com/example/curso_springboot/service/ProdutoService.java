package com.example.curso_springboot.service;

import com.example.curso_springboot.exceptions.RecursoNaoEncontradoException;
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

    public Produto buscarPorId(long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado!"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id){

        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado!");
        }
        produtoRepository.deleteAllById(Collections.singleton(id));
    }
}
