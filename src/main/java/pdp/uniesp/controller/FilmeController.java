package pdp.uniesp.controller;

import pdp.uniesp.model.dto.FilmeDTO;
import pdp.uniesp.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
@Slf4j
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listarTodos() {
        log.info("Chamando método listarTodos no FilmeController");
        List<FilmeDTO> filmes = filmeService.listarTodos();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando método buscarPorId no FilmeController com id: {}", id);
        Optional<FilmeDTO> filme = filmeService.buscarPorId(id);
        return filme.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criarFilme(@RequestBody FilmeDTO filmeDTO) {
        log.info("Chamando método criarFilme no FilmeController com dados: {}", filmeDTO);
        FilmeDTO filmeCriado = filmeService.criarFilme(filmeDTO);
        return ResponseEntity.ok(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        log.info("Chamando método atualizarFilme no FilmeController com id: {} e dados: {}", id, filmeDTO);
        Optional<FilmeDTO> filmeAtualizado = filmeService.atualizarFilme(id, filmeDTO);
        return filmeAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        log.info("Chamando método deletarFilme no FilmeController com id: {}", id);
        boolean deletado = filmeService.deletarFilme(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
