package pdp.uniesp.service;

import pdp.uniesp.model.Produtor;
import pdp.uniesp.repository.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public List<Produtor> listarTodos() {
        return produtorRepository.findAll();
    }

    public Optional<Produtor> buscarPorId(Long id) {
        return produtorRepository.findById(id);
    }

    public Optional<Produtor> buscarPorNome(String nome) {
        return produtorRepository.findByNome(nome);
    }

    public Produtor criarProdutor(Produtor produtor) {
        return produtorRepository.save(produtor);
    }
}