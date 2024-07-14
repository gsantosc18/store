# Store

Este projeto é uma aplicação de gerenciamento de produtos e estoque desenvolvida em Kotlin utilizando Spring Boot. A aplicação permite realizar operações CRUD (Create, Read, Update, Delete) para gerenciar produtos e controlar o estoque.

## Funcionalidades

- Adicionar novos produtos
- Visualizar detalhes dos produtos
- Atualizar informações dos produtos
- Remover produtos
- Gerenciar o estoque em tempo real

## Tecnologias Utilizadas

- Kotlin
- Spring Boot
- Spring Data JPA
- H2 Database (para desenvolvimento e testes)
- Maven (para gerenciamento de dependências)
- Micrometer (Observabilidade)

## Configuração e Execução

### Pré-requisitos

- JDK 17 ou superior
- Maven

### Passos para Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/gsantosc18/store.git
   cd store
   ```

2. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

3. Acesse a aplicação no navegador:
   ```sh
   http://localhost:8080
   ```

## Endpoints da API

Abaixo estão os endpoints principais da aplicação:

### Produtos

- **GET /products**: Lista todos os produtos
- **GET /products/{id}**: Visualiza os detalhes de um produto específico
- **POST /products**: Adiciona um novo produto
- **PUT /products/{id}**: Atualiza as informações de um produto específico
- **DELETE /products/{id}**: Remove um produto específico

### Estoque

- **GET /products/{id}/stock**: Visualiza o estoque de um produto específico
- **PUT /products/{id}/stock**: Atualiza o estoque de um produto específico

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

Esse README fornece uma visão geral do projeto, detalha suas funcionalidades e oferece instruções claras sobre como configurar e executar a aplicação.