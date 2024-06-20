package br.com.gustavokonzen.api_escriba.repository;

import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoCartorioRepository extends JpaRepository<SituacaoCartorio, String> {
    SituacaoCartorio findByNome(String nome);
}
