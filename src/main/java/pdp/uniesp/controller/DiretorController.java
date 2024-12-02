package pdp.uniesp.controller;

import pdp.uniesp.model.dto.DiretorDTO;
import pdp.uniesp.service.DiretorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diretor")
@RequiredArgsConstructor
@Slf4j
public class DiretorController {
    private final DiretorService diretorService;

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> listarTodos(){
        log.info("Chamando método listarTodos no DiretorController");
        List<DiretorDTO> diretor = diretorService.listarTodos();
        return ResponseEntity.ok(diretor);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscarPorId(@PathVariable Long id){
        log.info("Chamando método buscarPorId no DiretorController com id: {}", id);
        Optional<DiretorDTO> diretor = diretorService.buscarPorId(id);
        return diretor.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<DiretorDTO> criarDiretor(@RequestBody DiretorDTO diretorDTO){
        log.info("Chamando método criarDiretor no DiretorController com dados: {}", diretorDTO);
        DiretorDTO diretorCriado = diretorService.criarDiretor(diretorDTO);
        return ResponseEntity.ok(diretorCriado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DiretorDTO> atualizarDiretor(@PathVariable Long id, @RequestBody DiretorDTO diretorDTO){
        log.info("Chamando método atualizarDiretor no DiretorController com id: {}", id, diretorDTO);
        Optional<DiretorDTO> diretorAtualizado = diretorService.atualizarDiretor(id, diretorDTO);
        return diretorAtualizado.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretor(@PathVariable Long id){
        log.info("Chamando método deletarDiretor no DiretorController com id: {}", id);
        boolean deletado = diretorService.deletarDiretor(id);
        if(deletado){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}