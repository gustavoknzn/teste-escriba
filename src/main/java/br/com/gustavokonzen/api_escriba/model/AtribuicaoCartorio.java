package br.com.gustavokonzen.api_escriba.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
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
        return "Atribuição: " + getNome();
    }
}