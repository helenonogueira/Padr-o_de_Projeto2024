package pdp.uniesp.controller;

import pdp.uniesp.model.Produtor;
import pdp.uniesp.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtores")
@RequiredArgsConstructor
@Slf4j
public class ProdutorController {

    private final ProdutorService produtorService;

    @GetMapping
    public ResponseEntity<List<Produtor>> listarTodos() {
        log.info("Chamando método listarTodos no ProdutorController");
        List<Produtor> produtores = produtorService.listarTodos();
        return ResponseEntity.ok(produtores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtor> buscarPorId(@PathVariable Long id) {
        log.info("Chamando método buscarPorId no ProdutorController com id: {}", id);
        Optional<Produtor> produtor = produtorService.buscarPorId(id);
        return produtor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<Produtor> buscarPorNome(@PathVariable String nome) {
        log.info("Chamando método buscarPorNome no ProdutorController com nome: {}", nome);
        Optional<Produtor> produtor = produtorService.buscarPorNome(nome);
        return produtor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produtor> criarProdutor(@RequestBody Produtor produtor) {
        log.info("Chamando método criarProdutor no ProdutorController com dados: {}", produtor);
        Produtor produtorCriado = produtorService.criarProdutor(produtor);
        return ResponseEntity.ok(produtorCriado);
    }
}