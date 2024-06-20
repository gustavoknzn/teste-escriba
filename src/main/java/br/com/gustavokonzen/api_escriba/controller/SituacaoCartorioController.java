package br.com.gustavokonzen.api_escriba.controller;

import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import br.com.gustavokonzen.api_escriba.service.SituacaoCartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/situacao")
public class SituacaoCartorioController {

    @Autowired
    private SituacaoCartorioService situacaoCartorioService;

    @GetMapping
    public ResponseEntity<List<SituacaoCartorio>> listarTodos() {
        List<SituacaoCartorio> situacoes = situacaoCartorioService.listarTodos();
        return ResponseEntity.ok(situacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoCartorio> buscarPorId(@PathVariable String id) {
        Optional<SituacaoCartorio> situacaoCartorio = situacaoCartorioService.buscarPorId(id);
        return situacaoCartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SituacaoCartorio> criar(@RequestBody SituacaoCartorio situacaoCartorio) {
        SituacaoCartorio situacaoCriada = situacaoCartorioService.salvar(situacaoCartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(situacaoCriada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        situacaoCartorioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
