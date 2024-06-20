package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository cartorioRepository;

    public List<Cartorio> listarTodos() {
        return cartorioRepository.findAll();
    }

    public Optional<Cartorio> buscarPorId(int id) {
        return cartorioRepository.findById(id);
    }

    public Cartorio salvar(Cartorio cartorio) {
        return cartorioRepository.save(cartorio);
    }

    public void deletar(int id) {
        cartorioRepository.deleteById(id);
    }
}
