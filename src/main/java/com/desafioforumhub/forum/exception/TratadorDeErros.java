package com.desafioforumhub.forum.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> tratarErroAutenticacao() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Acesso negado. Você precisa estar autenticado.");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarErro404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Recurso não encontrado.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarValidacoes(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors().stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(erros);
    }
}
