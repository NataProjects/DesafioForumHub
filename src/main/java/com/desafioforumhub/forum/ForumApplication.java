package com.desafioforumhub.forum;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(ForumApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void aoIniciarAplicacao() {
		System.out.println("🚀 Aplicação Forum API iniciada com sucesso!");
	}

}
