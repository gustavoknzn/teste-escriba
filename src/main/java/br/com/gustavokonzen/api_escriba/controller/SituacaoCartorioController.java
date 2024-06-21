package br.com.gustavokonzen.api_escriba.controller;

import br.com.gustavokonzen.api_escriba.annotation.ApiPageableSwagger2;
import br.com.gustavokonzen.api_escriba.dto.AtribuicaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.dto.SituacaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import br.com.gustavokonzen.api_escriba.service.SituacaoCartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/situacao")
public class SituacaoCartorioController {

    @Autowired
    private SituacaoCartorioService situacaoCartorioService;

    @GetMapping
    @ApiPageableSwagger2
    public ResponseEntity<List<SituacaoCartorioDTO>> listarTodos(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        var situacaoCartorios = situacaoCartorioService.listarTodos(pageable);
        return ResponseEntity.ok(situacaoCartorios);
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
    public ResponseEntity<?> deletar(@PathVariable String id) {
        Optional<SituacaoCartorio> situacaoCartorio = situacaoCartorioService.buscarPorId(id);
        if (situacaoCartorio.isPresent()){
            situacaoCartorioService.deletar(id);
            return ResponseEntity.ok().body("Situação: " + id + " excluída com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Situação: " + id + " não encontrada!");
        }
    }
}
