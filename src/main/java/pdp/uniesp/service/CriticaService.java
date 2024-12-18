package pdp.uniesp.service;

import pdp.uniesp.model.Critica;
import pdp.uniesp.repository.CriticaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CriticaService {

    private final CriticaRepository criticaRepository;

    public List<Critica> listarTodos() {
        return criticaRepository.findAll();
    }

    public Optional<Critica> buscarPorId(Long id) {
        return criticaRepository.findById(id);
    }

    public List<Critica> buscarPorFilmeId(Long filmeId) {
        return criticaRepository.findByFilmeId(filmeId);
    }

    public Critica criarCritica(Critica critica) {
        return criticaRepository.save(critica);
    }
}