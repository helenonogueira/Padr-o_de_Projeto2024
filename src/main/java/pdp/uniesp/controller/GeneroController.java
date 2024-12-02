package pdp.uniesp.controller;

import pdp.uniesp.model.dto.GeneroDTO;
import pdp.uniesp.service.GeneroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
@RequiredArgsConstructor
@Slf4j
public class GeneroController {
    private final GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> listarTodos(){
        log.info("Chamando método listarTodos no GeneroController");
        List<GeneroDTO> genero = generoService.listarTodos();
        return ResponseEntity.ok(genero);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> buscarPorId(@PathVariable Long id){
        log.info("Chamando método buscarId no GeneroController com id: {}", id);
        Optional<GeneroDTO> genero = generoService.buscarPorId(id);
        return genero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<GeneroDTO> criarGenero(@RequestBody GeneroDTO generoDTO){
        log.info("Chamando método criarGenero no GeneroController com dados: {}", generoDTO);
        GeneroDTO generoCriado = generoService.criarGenero(generoDTO);
        return ResponseEntity.ok(generoCriado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> atualizarGenero(@PathVariable Long id, @RequestBody GeneroDTO generoDTO){
        log.info("Chamando método atualizarGenero no GeneroController com id: {}", id, generoDTO);
        Optional<GeneroDTO> generoAtualizado = generoService.atualizarGenero(id, generoDTO);
        return generoAtualizado.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero(@PathVariable Long id){
        log.info("Chamando método deletarGenero no GeneroController com id: {}", id);
        boolean deletado = generoService.deletarGenero(id);
        if(deletado){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}