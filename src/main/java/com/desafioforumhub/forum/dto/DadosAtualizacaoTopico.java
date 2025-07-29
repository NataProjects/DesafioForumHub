package com.desafioforumhub.forum.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem
) {}
