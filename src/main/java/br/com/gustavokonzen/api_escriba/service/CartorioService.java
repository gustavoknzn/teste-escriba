package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository cartorioRepository;

    public List<CartorioDTO> listarTodos(Pageable pageable) {
        var cartorios = cartorioRepository.findAll(pageable).getContent();
        return CartorioDTO.converter(cartorios);
    }

    public Optional<Cartorio> buscarPorId(int id) {
        return cartorioRepository.findById(id);
    }

    @Transactional
    public Cartorio salvar(Cartorio cartorio) {
        return cartorioRepository.save(cartorio);
    }

    @Transactional
    public Cartorio atualizar(Integer id, Cartorio cartorioAtualizado) {
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(id);

        Cartorio cartorioExistente = cartorioOptional.get();

        if (cartorioAtualizado.getNome() != null) {
            cartorioExistente.setNome(cartorioAtualizado.getNome());
        }
        if (cartorioAtualizado.getObservacao() != null) {
            cartorioExistente.setObservacao(cartorioAtualizado.getObservacao());
        }
        if (cartorioAtualizado.getSituacao() != null) {
            cartorioExistente.setSituacao(cartorioAtualizado.getSituacao());
        }
        if (cartorioAtualizado.getAtribuicaoCartorioList() != null && !cartorioAtualizado.getAtribuicaoCartorioList().isEmpty()) {
            cartorioExistente.setAtribuicaoCartorioList(cartorioAtualizado.getAtribuicaoCartorioList());
        }

        return cartorioRepository.save(cartorioExistente);
    }

    public void deletar(int id) {
        cartorioRepository.deleteById(id);
    }
}
