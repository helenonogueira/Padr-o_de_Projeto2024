package pdp.uniesp.repository;

import pdp.uniesp.model.Critica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriticaRepository extends JpaRepository<Critica, Long> {
    List<Critica> findByFilmeId(Long filmeId);
}