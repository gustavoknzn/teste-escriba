package br.com.gustavokonzen.api_escriba.repository;

import br.com.gustavokonzen.api_escriba.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    Cartorio findByNome(String s);
}
