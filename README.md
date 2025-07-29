# 🧵 Fórum API - Spring Boot

Este projeto foi criado como parte do Challenge FórumHub proposto durante a formação em programação da Alura, na trilha ONE - Oracle Next Education (Turma 8).
É uma API REST para gerenciamento de tópicos de um fórum, construída com Java 17 e Spring Boot.
O sistema possui autenticação via JWT e permite o cadastro, listagem, atualização e remoção de tópicos, além de autenticação de usuários.
É um backend completo, desacoplado, seguro e pronto para produção.

---

## 🚀 Tecnologias utilizadas

- [JAVA 17](https://www.w3schools.com/java/)
- [SPRING BOOT](https://docs.spring.io/spring-boot/tutorial/index.html)
- [SPRING WEB](https://spring.io/guides/gs/serving-web-content/)
- [SPRING SECURITY](https://www.geeksforgeeks.org/advance-java/spring-security-tutorial/)
- [SPRING DATA JPA](https://spring.io/projects/spring-data-jpa)
- [FLYWAY](https://www.baeldung.com/database-migrations-with-flyway)
- [MYSQL](https://www.geeksforgeeks.org/mysql/mysql-tutorial/)
- [LOMBOK](https://www.baeldung.com/intro-to-project-lombok) 
- [JWT (JSON WEB TOKEN)](https://jwt.io/introduction)  
- [MAVEN](https://www.tutorialspoint.com/maven/index.htm)
- [.ENV PARA VARIÁVEIS SENSÍVEIS](https://dev.to/adnanrahic/how-to-use-environment-variables-in-java-1k3d)

---

## 🧩 Funcionalidades

| Funcionalidade               | Autenticação |
|-----------------------------|--------------|
| ✅ Autenticar (login)       | Não          |
| ✅ Listar todos os tópicos  | Não (Público)|
| ✅ Buscar tópico por ID     | Não (Público)|
| ✅ Criar novo tópico        | Sim (JWT)    |
| ✅ Atualizar tópico         | Sim (JWT)    |
| ✅ Deletar tópico           | Sim (JWT)    |

---


## 💻 Como rodar na sua máquina

### Pré-requisitos

- Java 17+
- MySQL
- Maven

### Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/NataProjects/DesafioForumHub.git
   cd DesafioForumHub
Crie um banco MySQL com o nome desejado.

Crie um arquivo .env com os seguintes valores (não versionado):

- DB_PASSWORD=suasenhadobanco
- JWT_SECRET=suaChaveJWTsecreta

Configure o application.properties com as variáveis:

- spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
- spring.datasource.username=root
- spring.datasource.password=${DB_PASSWORD}
- spring.jpa.hibernate.ddl-auto=validate
- spring.flyway.enabled=true
- jwt.secret=${JWT_SECRET}


🛡️ Observações
Apenas os endpoints de criação, edição e exclusão de tópicos exigem autenticação.

Listagem e visualização de tópicos são públicas.

Senhas são criptografadas.

JWT gerado possui tempo de expiração configurável.


# Desenvolvido por:

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/200856850?v=4&size=64" width=115><br><sub>NataProjects</sub>](https://github.com/NataProjects) |
 :---: |
