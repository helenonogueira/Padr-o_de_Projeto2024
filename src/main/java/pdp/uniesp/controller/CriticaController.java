package pdp.uniesp.controller;

import pdp.uniesp.model.Critica;
import pdp.uniesp.service.CriticaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/criticas")
@RequiredArgsConstructor
@Slf4j
public class CriticaController {

    private final CriticaService criticaService;

    @GetMapping
    public ResponseEntity<List<Critica>> listarTodos() {
        log.info("Chamando método listarTodos no CriticaController");
        List<Critica> criticas = criticaService.listarTodos();
        return ResponseEntity.ok(criticas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Critica> buscarPorId(@PathVariable Long id) {
        log.info("Chamando método buscarPorId no CriticaController com id: {}", id);
        Optional<Critica> critica = criticaService.buscarPorId(id);
        return critica.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filme/{filmeId}")
    public ResponseEntity<List<Critica>> buscarPorFilmeId(@PathVariable Long filmeId) {
        log.info("Chamando método buscarPorFilmeId no CriticaController com filmeId: {}", filmeId);
        List<Critica> criticas = criticaService.buscarPorFilmeId(filmeId);
        return ResponseEntity.ok(criticas);
    }

    @PostMapping
    public ResponseEntity<Critica> criarCritica(@RequestBody Critica critica) {
        log.info("Chamando método criarCritica no CriticaController com dados: {}", critica);
        Critica criticaCriada = criticaService.criarCritica(critica);
        return ResponseEntity.ok(criticaCriada);
    }
}