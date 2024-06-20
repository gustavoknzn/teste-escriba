package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.repository.AtribuicaoCartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtribuicaoCartorioService {

    @Autowired
    private AtribuicaoCartorioRepository atribuicaoCartorioRepository;

    public List<AtribuicaoCartorio> listarTodos() {
        return atribuicaoCartorioRepository.findAll();
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
