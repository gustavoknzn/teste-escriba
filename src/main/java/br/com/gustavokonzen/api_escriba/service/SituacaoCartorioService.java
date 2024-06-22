package br.com.gustavokonzen.api_escriba.service;

import br.com.gustavokonzen.api_escriba.dto.SituacaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.dto.SituacaoCartorioRequestDTO;
import br.com.gustavokonzen.api_escriba.exception.CampoNaoEncontradoException;
import br.com.gustavokonzen.api_escriba.exception.ErroNaoMapeadoException;
import br.com.gustavokonzen.api_escriba.exception.RegistroDuplicadoException;
import br.com.gustavokonzen.api_escriba.exception.RegistroNaoEncontradoException;
import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import br.com.gustavokonzen.api_escriba.repository.SituacaoCartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
        if (Objects.isNull(situacaoCartorio)) {
            throw new ErroNaoMapeadoException("Situação cartório não pode ser vazio");
        }
        if (situacaoCartorio.getId().isBlank()) {
            throw new CampoNaoEncontradoException("O campo 'ID' é obrigatório");
        }
        if (situacaoCartorio.getNome().isEmpty()) {
            throw new CampoNaoEncontradoException("O campo 'Nome' é obrigatório");
        }
        var situacaoCartorioDB = situacaoCartorioRepository.findByNome(situacaoCartorio.getNome());
        if (situacaoCartorio.getId().equals(situacaoCartorioDB.getId())) {
            throw new RegistroDuplicadoException("Registro já cadastrado!");
        }
        if (situacaoCartorio.getNome().equals(situacaoCartorioDB.getNome())) {
            throw new RegistroDuplicadoException("Nome já informado no registro: " + situacaoCartorioDB.getId());
        }
        return situacaoCartorioRepository.save(situacaoCartorio);
    }

    public void deletar(String id) {
        if (situacaoCartorioRepository.findById(id).isPresent()) {
            situacaoCartorioRepository.deleteById(id);
        } else {
            throw new RegistroNaoEncontradoException("Situação: " + id + " não encontrada!");
        }
    }

    @Transactional
    public SituacaoCartorio atualizar(String id, SituacaoCartorioRequestDTO situacaoCartorioAtualizado) {
        var situacaoCartorioExistente = situacaoCartorioRepository.findByNome(situacaoCartorioAtualizado.getNome());

        if (Objects.isNull(situacaoCartorioExistente)) {
            situacaoCartorioExistente = situacaoCartorioRepository.findById(id).get();
        }

        if (situacaoCartorioExistente.getId() != id && situacaoCartorioExistente.getNome().equals(situacaoCartorioAtualizado.getNome())) {
            throw new RegistroDuplicadoException("Nome já cadastrado na situação: " + situacaoCartorioExistente.getId());
        }

        if (situacaoCartorioAtualizado.getNome() != null && !situacaoCartorioAtualizado.getNome().isEmpty()) {
            situacaoCartorioExistente.setNome(situacaoCartorioAtualizado.getNome());
        }
        return situacaoCartorioRepository.save(situacaoCartorioExistente);
    }
}
