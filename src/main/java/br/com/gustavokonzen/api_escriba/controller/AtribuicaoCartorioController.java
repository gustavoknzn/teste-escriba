package br.com.gustavokonzen.api_escriba.controller;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.service.AtribuicaoCartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atribuicao")
public class AtribuicaoCartorioController {

    @Autowired
    private AtribuicaoCartorioService atribuicaoCartorioService;

    @GetMapping
    public ResponseEntity<List<AtribuicaoCartorio>> listarTodos() {
        List<AtribuicaoCartorio> atribuicoes = atribuicaoCartorioService.listarTodos();
        return ResponseEntity.ok(atribuicoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtribuicaoCartorio> buscarPorId(@PathVariable String id) {
        Optional<AtribuicaoCartorio> atribuicaoCartorio = atribuicaoCartorioService.buscarPorId(id);
        return atribuicaoCartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtribuicaoCartorio> criar(@RequestBody AtribuicaoCartorio atribuicaoCartorio) {
        AtribuicaoCartorio atribuicaoCriada = atribuicaoCartorioService.salvar(atribuicaoCartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(atribuicaoCriada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        atribuicaoCartorioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
