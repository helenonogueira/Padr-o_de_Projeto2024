package pdp.uniesp.service;

import pdp.uniesp.model.Cinematografia;
import pdp.uniesp.repository.CinematografiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinematografiaService {

    private final CinematografiaRepository cinematografiaRepository;

    public List<Cinematografia> listarTodos() {
        return cinematografiaRepository.findAll();
    }

    public Optional<Cinematografia> buscarPorId(Long id) {
        return cinematografiaRepository.findById(id);
    }

    public List<Cinematografia> buscarPorFilmeId(Long filmeId) {
        return cinematografiaRepository.findByFilmeId(filmeId);
    }

    public Cinematografia criarCinematografia(Cinematografia cinematografia) {
        return cinematografiaRepository.save(cinematografia);
    }
}