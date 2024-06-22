package br.com.gustavokonzen.api_escriba.repository;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtribuicaoCartorioRepository extends JpaRepository<AtribuicaoCartorio, String> {
    AtribuicaoCartorio findByNome(String nome);

    AtribuicaoCartorio findFirstByIdOrNome(String id, String nome);
}
