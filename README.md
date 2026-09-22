# ArqManager 🏗️

API REST desenvolvida em Spring Boot para a gestão de projetos de arquitetura. O sistema permite listar, registar, atualizar o estado e eliminar projetos.

## 🛠️ Tecnologias Utilizadas

* **Java 25**
* **Spring Boot 4.1.1**
* **Spring Web** (Rotas HTTP e API REST)
* **Spring Data JPA** (Persistência e comunicação com a base de dados)
* **MySQL** (Base de dados relacional)
* **Lombok** (Redução de código boilerplate)

## 🏗️ Arquitetura do Projeto

O projeto segue a arquitetura em camadas (Layered Architecture):
* **Controller:** Gere as requisições HTTP e retorna as respostas.
* **Service:** Contém a lógica de negócio e validações.
* **Repository:** Interface de comunicação com a base de dados (JPA).
* **Entity:** Representa a tabela `projeto_arquitetura` na base de dados.