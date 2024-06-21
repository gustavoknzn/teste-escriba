package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.dto.AtribuicaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.model.Cartorio;
import br.com.gustavokonzen.api_escriba.repository.AtribuicaoCartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class AtribuicaoCartorioService {

    @Autowired
    private AtribuicaoCartorioRepository atribuicaoCartorioRepository;

    public List<AtribuicaoCartorioDTO> listarTodos(Pageable pageable) {
        var atribuicaoCartorios = atribuicaoCartorioRepository.findAll(pageable).getContent();
        return AtribuicaoCartorioDTO.converter(atribuicaoCartorios);
    }

    public Optional<AtribuicaoCartorio> buscarPorId(String id) {
        return atribuicaoCartorioRepository.findById(id);
    }

    public AtribuicaoCartorio salvar(AtribuicaoCartorio atribuicaoCartorio) {
        return atribuicaoCartorioRepository.save(atribuicaoCartorio);
    }

    @Transactional
    public AtribuicaoCartorio atualizar(String id, AtribuicaoCartorio AtribuicaocartorioAtualizado) {
        Optional<AtribuicaoCartorio> atribuicaocartorioOptional = atribuicaoCartorioRepository.findById(id);

        AtribuicaoCartorio atribuicaoCartorioExistente = atribuicaocartorioOptional.get();

        if (AtribuicaocartorioAtualizado.getId() != null && !AtribuicaocartorioAtualizado.getId().isEmpty()) {
            atribuicaoCartorioExistente.setId(AtribuicaocartorioAtualizado.getId());
        }
        if (AtribuicaocartorioAtualizado.getNome() != null && !AtribuicaocartorioAtualizado.getNome().isEmpty()) {
            atribuicaoCartorioExistente.setNome(AtribuicaocartorioAtualizado.getNome());
        }

        return atribuicaoCartorioRepository.save(atribuicaoCartorioExistente);
    }

    public void deletar(String id) {
        atribuicaoCartorioRepository.deleteById(id);
    }
}
