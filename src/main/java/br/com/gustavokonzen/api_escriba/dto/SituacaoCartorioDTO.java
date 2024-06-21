package br.com.gustavokonzen.api_escriba.dto;

import br.com.gustavokonzen.api_escriba.model.AtribuicaoCartorio;
import br.com.gustavokonzen.api_escriba.model.SituacaoCartorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SituacaoCartorioDTO {

    private String id;
    private String nome;

    public static List<SituacaoCartorioDTO> converter(List<SituacaoCartorio> situacaoCartorios) {
        return situacaoCartorios.stream().map(situacaoCartorio -> new SituacaoCartorioDTO(situacaoCartorio.getId(),situacaoCartorio.getNome())).collect(Collectors.toList());
    }
}
