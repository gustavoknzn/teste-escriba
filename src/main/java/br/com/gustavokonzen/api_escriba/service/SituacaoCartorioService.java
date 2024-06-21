package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.dto.AtribuicaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.dto.SituacaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import br.com.gustavokonzen.api_escriba.repository.SituacaoCartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoCartorioService {

    @Autowired
    private SituacaoCartorioRepository situacaoCartorioRepository;

    public List<SituacaoCartorioDTO> listarTodos(Pageable pageable) {
        var situacaoCartorios = situacaoCartorioRepository.findAll(pageable).getContent();
        return SituacaoCartorioDTO.converter(situacaoCartorios);
    }

    public Optional<SituacaoCartorio> buscarPorId(String id) {
        return situacaoCartorioRepository.findById(id);
    }

    public SituacaoCartorio salvar(SituacaoCartorio situacaoCartorio) {
        var s = situacaoCartorioRepository.findByNome(situacaoCartorio.getNome());
        if (s != null) throw new IllegalArgumentException("Já existe");
        return situacaoCartorioRepository.save(situacaoCartorio);
    }

    public void deletar(String id) {
        situacaoCartorioRepository.deleteById(id);
    }
}
