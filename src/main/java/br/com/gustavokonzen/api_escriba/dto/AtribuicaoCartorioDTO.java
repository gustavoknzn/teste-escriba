package br.com.gustavokonzen.api_escriba.dto;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtribuicaoCartorioDTO {

    private String id;
    private String nome;

    public static List<AtribuicaoCartorioDTO> converter(List<AtribuicaoCartorio> atribuicaoCartorios) {
        return atribuicaoCartorios.stream().map(atribuicaoCartorio -> new AtribuicaoCartorioDTO(atribuicaoCartorio.getId(), atribuicaoCartorio.getNome())).collect(Collectors.toList());
    }
}
