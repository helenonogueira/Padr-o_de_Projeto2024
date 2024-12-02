package pdp.uniesp.repository;

import pdp.uniesp.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
    Optional<Produtor> findByNome(String nome);
}