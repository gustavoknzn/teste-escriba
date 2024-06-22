package br.com.gustavokonzen.api_escriba.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorException {
    private String descricaoErro;
}
