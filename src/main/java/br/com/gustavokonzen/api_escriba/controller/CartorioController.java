package br.com.gustavokonzen.api_escriba.controller;

import br.com.gustavokonzen.api_escriba.annotation.ApiPageableSwagger2;
import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.service.CartorioService;
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
@RequestMapping("/api/cartorio")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @GetMapping
    @ApiPageableSwagger2
    public ResponseEntity<List<CartorioDTO>> listarTodos(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        var cartorios = cartorioService.listarTodos(pageable);
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
        Cartorio cartorioCriado = cartorioService.salvar(cartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartorioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> atualizar(@PathVariable int id, @RequestBody Cartorio cartorioAtualizado) {
        Cartorio cartorio = cartorioService.atualizar(id, cartorioAtualizado);
        return ResponseEntity.ok(cartorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        Optional<Cartorio> cartorioDB = cartorioService.buscarPorId(id);
        if (cartorioDB.isPresent()){
            cartorioService.deletar(id);
            return ResponseEntity.ok().body("Cartório: " + id + " excluído com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartório: " + id + " não encontrado!");
        }
    }
}
