package br.com.gabriel.arqmanager.controller;

import br.com.gabriel.arqmanager.entity.ProjetoArquitetonico;
import br.com.gabriel.arqmanager.service.ProjetoArquitetonicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projeto")
@RequiredArgsConstructor
public class ProjetoArquitetonicoController {

    private final ProjetoArquitetonicoService service;

    @GetMapping
    public ResponseEntity<List<ProjetoArquitetonico>> listarTodos(){
        return ResponseEntity.ok(service.recuperaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoArquitetonico> buscaPorId (@PathVariable Long id){
        return ResponseEntity.ok(service.recuperaPorId(id));
    }
    @GetMapping("nome/{nome}")
    public ResponseEntity<ProjetoArquitetonico> buscarPorNome (@PathVariable String nome){
        return ResponseEntity.ok(service.recuperaPeloNome(nome));
    }

    @PostMapping
    public ResponseEntity<ProjetoArquitetonico> registarProjeto(@RequestBody ProjetoArquitetonico projetoArquitetonico){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvaProjeto(projetoArquitetonico));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjetoArquitetonico> modificaPorId(@PathVariable Long id,@RequestBody ProjetoArquitetonico projetoArquitetonico){
        return ResponseEntity.ok(service.atualizaProjeto(id, projetoArquitetonico));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPorId(@PathVariable Long id){
        service.deletaPorId(id);
        return ResponseEntity.noContent().build();
    }




}
