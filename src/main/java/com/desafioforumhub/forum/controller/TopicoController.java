package com.desafioforumhub.forum.controller;

import com.desafioforumhub.forum.dto.*;
import com.desafioforumhub.forum.model.Topico;
import com.desafioforumhub.forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTopico>> listar() {
        var lista = repository.findAll().stream().map(DadosDetalhamentoTopico::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tópico com ID " + id + " não encontrado ou foi apagado.");
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = new Topico();
        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setNomeCurso(dados.nomeCurso());
        repository.save(topico);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.findById(id).orElseThrow();
        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        repository.save(topico);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
