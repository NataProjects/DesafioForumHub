package com.desafioforumhub.forum.config;

import com.desafioforumhub.forum.model.Usuario;
import com.desafioforumhub.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;

@Configuration
public class InitDevUser {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void criarUsuarioPadrao() {
        String email = "admin@forum.com";
        String senha = "1234";

        if (usuarioRepository.findByEmail(email).isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(passwordEncoder.encode(senha));
            usuarioRepository.save(usuario);

            System.out.println("Usuário admin criado com sucesso!");
        }
    }
}
