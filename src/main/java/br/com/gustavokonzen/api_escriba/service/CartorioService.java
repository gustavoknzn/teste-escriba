package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import br.com.gustavokonzen.api_escriba.exception.CampoNaoEncontradoException;
import br.com.gustavokonzen.api_escriba.exception.ErroNaoMapeadoException;
import br.com.gustavokonzen.api_escriba.exception.RegistroDuplicadoException;
import br.com.gustavokonzen.api_escriba.exception.RegistroNaoEncontradoException;
import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
        if(Objects.isNull(cartorio)){
            throw new ErroNaoMapeadoException("Cartório não pode ser vazio");
        }
        if (cartorio.getNome().isEmpty()) {
            throw new CampoNaoEncontradoException("O campo 'Nome' é obrigatório");
        }
        var cartorioDB = cartorioRepository.findByNome(cartorio.getNome());
        if (Objects.nonNull(cartorioDB) && cartorio.getNome().equals(cartorioDB.getNome())) {
            throw new RegistroDuplicadoException("Nome já informado no cartório: " + cartorioDB.getId());
        }
        return cartorioRepository.save(cartorio);
    }

    @Transactional
    public Cartorio atualizar(Integer id, Cartorio cartorioAtualizado) {
        var cartorioDB = cartorioRepository.findByNome(cartorioAtualizado.getNome());

        if(Objects.isNull(cartorioDB)){
            cartorioDB = cartorioRepository.findById(id).get();
        }
        if(cartorioDB.getId() != id && cartorioDB.getNome().equals(cartorioAtualizado.getNome())){
            throw new RegistroDuplicadoException("Nome já informado no cartório: " + cartorioDB.getId());
        }
        if (cartorioAtualizado.getNome() != null) {
            cartorioDB.setNome(cartorioAtualizado.getNome());
        }
        if (cartorioAtualizado.getObservacao() != null) {
            cartorioDB.setObservacao(cartorioAtualizado.getObservacao());
        }
        if (cartorioAtualizado.getSituacao() != null) {
            cartorioDB.setSituacao(cartorioAtualizado.getSituacao());
        }
        if (cartorioAtualizado.getAtribuicaoCartorioList() != null && !cartorioAtualizado.getAtribuicaoCartorioList().isEmpty()) {
            cartorioDB.setAtribuicaoCartorioList(cartorioAtualizado.getAtribuicaoCartorioList());
        }

        return cartorioRepository.save(cartorioDB);
    }

    public void deletar(int id) {
        if (cartorioRepository.findById(id).isPresent()) {
            cartorioRepository.deleteById(id);
        } else {
            throw new RegistroNaoEncontradoException("Cartório: " + id + " não encontrado!");
        }
    }
}
