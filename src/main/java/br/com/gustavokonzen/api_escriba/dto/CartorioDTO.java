package br.com.gustavokonzen.api_escriba.dto;

import br.com.gustavokonzen.api_escriba.model.Cartorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class CartorioDTO {

    private Integer id;
    private String nome;

    public static List<CartorioDTO> converter(List<Cartorio> cartorios) {
        return cartorios.stream().map(cartorio -> new CartorioDTO(cartorio.getId(),cartorio.getNome())).collect(Collectors.toList());
    }
}
