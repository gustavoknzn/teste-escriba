package br.com.gustavokonzen.api_escriba.repository;

import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import br.com.gustavokonzen.api_escriba.model.Cartorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
        Cartorio findByNome(String s);
}
