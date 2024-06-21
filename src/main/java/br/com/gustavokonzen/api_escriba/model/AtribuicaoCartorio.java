package br.com.gustavokonzen.api_escriba.model;

import br.com.gustavokonzen.api_escriba.dto.AtribuicaoCartorioDTO;
import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ATRIBUICAO_CARTORIO")
public class AtribuicaoCartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Override
    public String toString() {
        return "Código: " + getId() + "Nome: " + getNome();
    }

    public AtribuicaoCartorioDTO toDto(){
        return new AtribuicaoCartorioDTO(this.id, this.nome);
    }
}