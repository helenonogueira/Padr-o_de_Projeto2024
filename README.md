# Projeto API Rest - Padrões de Projeto

### Entidades e Endpoints

- **Ator**
  - `GET /ator`
  - `POST /ator`
  - `PUT /ator/{id}`
  - `DELETE /ator/{id}`
  - Implementou o `AtorService`, `AtorRepository` e o model `Ator` anotado com `@Entity`.

- **Cinematografia**
  - `GET /cinematografias`
  - `GET /cinematografias/{id}`
  - `GET /cinematografias/filme/{filmeId}`
  - `POST /cinematografias`
  - Implementou os métodos no `CinematografiaService`, `CinematografiaRepository` e a entidade `Cinematografia` anotada com `@Entity`.

- **Crítica**
  - `GET /criticas`
  - `GET /criticas/{id}`
  - `GET /criticas/filme/{filmeId}`
  - `POST /criticas`
  - Implementou os métodos no `CriticaService`, `CriticaRepository` e a entidade `Critica` anotada com `@Entity`.

- **Diretor**
  - `GET /diretor`
  - `POST /diretor`
  - `PUT /diretor/{id}`
  - `DELETE /diretor/{id}`
  - Implementou o `DiretorService`, `DiretorRepository` e o model `Diretor` anotado com `@Entity`.

- **Filme**
  - `GET /filmes`
  - `GET /filmes/{id}`
  - `POST /filmes`
  - `PUT /filmes/{id}`
  - `DELETE /filmes/{id}`
  - Implementou os métodos no `FilmeService`, `FilmeRepository` e a entidade `Filme` anotada com `@Entity`.

- **Produtor**
  - `GET /produtores`
  - `GET /produtores/{id}`
  - `GET /produtores/buscar/{nome}`
  - `POST /produtores`
  - Implementou os métodos no `ProdutorService`, `ProdutorRepository` e a entidade `Produtor` anotada com `@Entity`.

- **Trilha Sonora**
  - `GET /trilhas`
  - `GET /trilhas/{id}`
  - `GET /trilhas/compositor/{compositor}`
  - `POST /trilhas`
  - Implementou os métodos no `TrilhaSonoraService`, `TrilhaSonoraRepository` e a entidade `TrilhaSonora` anotada com `@Entity`.

- **Gênero**
  - `GET /genero`
  - `GET /genero/{id}`
  - `POST /genero`
  - `PUT /genero/{id}`
  - `DELETE /genero/{id}`
  - Implementou o `GeneroService`, `GeneroRepository` e o model `Genero` anotado com `@Entity`.
