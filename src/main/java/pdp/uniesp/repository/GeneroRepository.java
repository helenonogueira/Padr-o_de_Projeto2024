package pdp.uniesp.repository;

import pdp.uniesp.model.Filme;
import pdp.uniesp.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    @Query("SELECT g FROM Genero g WHERE g.nome LIKE %:nome%")
    List<Genero> buscarPorNome(@Param("nome") String nome);
    @Query("SELECT g FROM Genero g JOIN g.filmes f WHERE f IN :filmes")
    List<Genero> buscarPorFilme(@Param("filmes")List<Filme> filmes);
}