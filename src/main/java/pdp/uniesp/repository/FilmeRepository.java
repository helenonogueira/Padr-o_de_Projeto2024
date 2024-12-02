package pdp.uniesp.repository;

import pdp.uniesp.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query("SELECT f FROM Filme f WHERE f.titulo LIKE %:titulo%")
    List<Filme> buscarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT f FROM Filme f WHERE f.anoLancamento = :ano")
    List<Filme> buscarPorAno(@Param("ano") int ano);

    @Query("SELECT f FROM Filme f Where f.anoLancamento = :ano ORDER BY f.anoLancamento ASC")
    List<Filme> buscarPorAnoLancamento(@Param("ano") int ano);
}
