package br.com.gustavokonzen.api_escriba.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_SITUACAO_CARTORIO")
public class SituacaoCartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 50, nullable = false, unique = true)
    private String nome;

    @Override
    public String toString() {
        return "Código: " + getId() + "Nome: " + getNome();
    }
}