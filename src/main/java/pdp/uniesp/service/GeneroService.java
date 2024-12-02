package pdp.uniesp.service;

import pdp.uniesp.model.Genero;
import pdp.uniesp.model.dto.GeneroDTO;
import pdp.uniesp.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneroService {
    private final GeneroRepository generoRepository;
    public List<GeneroDTO> listarTodos(){
        return generoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Optional<GeneroDTO> buscarPorId(Long id){
        return generoRepository.findById(id)
                .map(this::convertToDTO);
    }

    public GeneroDTO criarGenero(GeneroDTO generoDTO){
        Genero genero = converToEntity(generoDTO);
        return convertToDTO(generoRepository.save(genero));
    }

    public Optional<GeneroDTO> atualizarGenero(Long id, GeneroDTO generoDTO){
        return generoRepository.findById(id).map(genero ->{
            genero.setId(generoDTO.getId());
            genero.setNome(generoDTO.getNome());
            return convertToDTO(generoRepository.save(genero));
        });
    }

    public boolean deletarGenero(Long id){
        if (generoRepository.existsById(id)){
            generoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private GeneroDTO convertToDTO(Genero genero){
        return new GeneroDTO(
                genero.getId(),
                genero.getNome()
        );
    }

    private Genero converToEntity(GeneroDTO generoDTO){
        Genero genero = new Genero();
        genero.setId(generoDTO.getId());
        genero.setNome(generoDTO.getNome());
        return genero;
    }
}