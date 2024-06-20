package br.com.gustavokonzen.api_escriba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TB_CARTORIO")
public class Cartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 250)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "situacao_id")
    private SituacaoCartorio situacao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_ATRIBUICAO_HAS_CARTORIO",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "atribuicao_id"))
    private List<AtribuicaoCartorio> atribuicaoCartorioList;

    @Override
    public String toString() {
        return "Cartorio: " + getNome();
    }
}