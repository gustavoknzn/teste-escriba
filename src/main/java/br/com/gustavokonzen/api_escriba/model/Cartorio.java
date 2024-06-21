package br.com.gustavokonzen.api_escriba.model;

import br.com.gustavokonzen.api_escriba.dto.CartorioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
        return "Código: " + getId() + "Nome: " + getNome();
    }

    public CartorioDTO toDto(){
        return new CartorioDTO(this.id, this.nome);
    }
}