package com.desafioforumhub.forum.controller;

import com.desafioforumhub.forum.dto.*;
import com.desafioforumhub.forum.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> autenticar(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        Authentication auth = authManager.authenticate(token);

        var jwt = tokenService.gerarToken(auth);
        return ResponseEntity.ok(new DadosTokenJWT(jwt, "Bearer"));
    }
}