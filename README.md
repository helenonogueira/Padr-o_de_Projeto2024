# Projeto API Rest - Padrões de Projeto

Este projeto é uma API RESTful que utiliza o padrão de projeto **Command** para encapsular solicitações como objetos, organizando a lógica de negócio e promovendo flexibilidade e manutenção no código. Foi desenvolvido em Java com o framework Spring Boot, seguindo uma arquitetura bem definida de **Controllers**, **Services** e **Repositories**, utilizando anotações do JPA para mapeamento das entidades.

## 📚 Padrão de Projeto Utilizado: Command

O padrão **Command** encapsula uma solicitação como um objeto, permitindo parametrizar clientes com diferentes solicitações, enfileirar ou registrar solicitações e suportar operações que podem ser desfeitas. No contexto deste projeto:

1. **Controllers**:
   - Cada endpoint no controller (ex.: `FilmeController`, `AtorController`, etc.) é tratado como um comando específico.
   - Ele recebe a requisição HTTP, encapsula as informações da solicitação e encaminha a execução para o respectivo **Service**.

2. **Services**:
   - Os serviços correspondentes (ex.: `FilmeService`, `AtorService`, etc.) contêm a lógica de negócios para executar os comandos, como criar, atualizar, buscar ou excluir entidades.
   - Exemplo: o endpoint `POST /filmes` no `FilmeController` representa o comando "Criar Filme", que é encaminhado para o método `criarFilme` no `FilmeService`.

3. **Repositories**:
   - Os repositórios (ex.: `FilmeRepository`, `AtorRepository`, etc.) são responsáveis por interagir diretamente com o banco de dados, abstraindo os detalhes de persistência e recuperação de dados.

### Benefícios do Padrão Command no Projeto:
- **Organização**: As solicitações estão encapsuladas como comandos, facilitando a leitura e a manutenção.
- **Flexibilidade**: Permite a introdução de novos comandos (endpoints) sem grandes impactos no restante do código.
- **Reutilização**: A lógica de negócios nos serviços é independente do tipo de solicitação, promovendo a reutilização e o teste de unidades específicas.
- **Extensibilidade**: Comandos podem ser enfileirados, registrados ou até desfeitos se necessário.

Além disso, o padrão **Command** funciona bem com outros padrões, como:
- **Dependency Injection**: Utilizado com `@Autowired` para gerenciar dependências entre os componentes.
- **Repository**: Para acessar o banco de dados.

---

## 📌 Entidades e Endpoints

A API está organizada com as seguintes entidades e seus respectivos endpoints:

### Ator
- **Endpoints**:
  - `GET /ator`
  - `POST /ator`
  - `PUT /ator/{id}`
  - `DELETE /ator/{id}`
- Implementações:
  - `AtorService`, `AtorRepository` e a entidade `Ator` anotada com `@Entity`.

### Cinematografia
- **Endpoints**:
  - `GET /cinematografias`
  - `GET /cinematografias/{id}`
  - `GET /cinematografias/filme/{filmeId}`
  - `POST /cinematografias`
- Implementações:
  - `CinematografiaService`, `CinematografiaRepository` e a entidade `Cinematografia` anotada com `@Entity`.

### Crítica
- **Endpoints**:
  - `GET /criticas`
  - `GET /criticas/{id}`
  - `GET /criticas/filme/{filmeId}`
  - `POST /criticas`
- Implementações:
  - `CriticaService`, `CriticaRepository` e a entidade `Critica` anotada com `@Entity`.

### Diretor
- **Endpoints**:
  - `GET /diretor`
  - `POST /diretor`
  - `PUT /diretor/{id}`
  - `DELETE /diretor/{id}`
- Implementações:
  - `DiretorService`, `DiretorRepository` e a entidade `Diretor` anotada com `@Entity`.

### Filme
- **Endpoints**:
  - `GET /filmes`
  - `GET /filmes/{id}`
  - `POST /filmes`
  - `PUT /filmes/{id}`
  - `DELETE /filmes/{id}`
- Implementações:
  - `FilmeService`, `FilmeRepository` e a entidade `Filme` anotada com `@Entity`.

### Produtor
- **Endpoints**:
  - `GET /produtores`
  - `GET /produtores/{id}`
  - `GET /produtores/buscar/{nome}`
  - `POST /produtores`
- Implementações:
  - `ProdutorService`, `ProdutorRepository` e a entidade `Produtor` anotada com `@Entity`.

### Trilha Sonora
- **Endpoints**:
  - `GET /trilhas`
  - `GET /trilhas/{id}`
  - `GET /trilhas/compositor/{compositor}`
  - `POST /trilhas`
- Implementações:
  - `TrilhaSonoraService`, `TrilhaSonoraRepository` e a entidade `TrilhaSonora` anotada com `@Entity`.

### Gênero
- **Endpoints**:
  - `GET /genero`
  - `GET /genero/{id}`
  - `POST /genero`
  - `PUT /genero/{id}`
  - `DELETE /genero/{id}`
- Implementações:
  - `GeneroService`, `GeneroRepository` e a entidade `Genero` anotada com `@Entity`.

---

## 🔧 Tecnologias Utilizadas
- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento da API.
- **JPA (Java Persistence API)**: Mapeamento objeto-relacional.
- **H2 Database**: Banco de dados para desenvolvimento.
- **Postman**: Testes e documentação da API.

---

## 🚀 Como Executar
1. Clone este repositório.
2. Configure o ambiente Java e Spring Boot.
3. Execute a aplicação pelo arquivo principal.
4. Utilize ferramentas como Postman para testar os endpoints.

---

