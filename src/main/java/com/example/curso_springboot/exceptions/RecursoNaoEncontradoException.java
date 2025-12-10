package com.example.curso_springboot.exceptions;


public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
