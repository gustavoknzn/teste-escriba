package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.repository.AtribuicaoCartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AtribuicaoCartorioService {

    @Autowired
    private AtribuicaoCartorioRepository atribuicaoCartorioRepository;

    public Page<AtribuicaoCartorio> listarTodos(Pageable pageable) {
        return atribuicaoCartorioRepository.findAll(pageable);
    }

    public Optional<AtribuicaoCartorio> buscarPorId(String id) {
        return atribuicaoCartorioRepository.findById(id);
    }

    public AtribuicaoCartorio salvar(AtribuicaoCartorio atribuicaoCartorio) {
        return atribuicaoCartorioRepository.save(atribuicaoCartorio);
    }

    public void deletar(String id) {
        atribuicaoCartorioRepository.deleteById(id);
    }
}
