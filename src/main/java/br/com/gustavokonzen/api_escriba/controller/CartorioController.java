package br.com.gustavokonzen.api_escriba.controller;

import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import br.com.gustavokonzen.api_escriba.service.CartorioService;
import br.com.gustavokonzen.api_escriba.service.SituacaoCartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartorio")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @GetMapping
    public ResponseEntity<List<Cartorio>> listarTodos() {
        List<Cartorio> cartorios = cartorioService.listarTodos();
        return ResponseEntity.ok(cartorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartorio> buscarPorId(@PathVariable int id) {
        Optional<Cartorio> cartorio = cartorioService.buscarPorId(id);
        return cartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cartorio> criar(@RequestBody Cartorio cartorio) {
        System.out.println(cartorio);
        Cartorio cartorioCriado = cartorioService.salvar(cartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartorioCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        cartorioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
