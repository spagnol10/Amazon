package br.com.well.api.amazon.model.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumErrorCodeProduct {

    PRODUTO_NAO_ENCONTRADO("01", "Id do produto informado não existe na base de dados!", HttpStatus.NOT_FOUND),
    ERRO_AO_CADASTRAR_PRODUTO("02", "Ocorreu um erro interno e não foi possível cadastrar o produto!",
            HttpStatus.INTERNAL_SERVER_ERROR);

    private String key;

    private String value;

    private HttpStatus httpStatus;

    public static EnumErrorCodeProduct parseByKey(String key) {

        for (EnumErrorCodeProduct enumError : EnumErrorCodeProduct.values()) {
            if (enumError.getKey().equals(key)) {
                return enumError;
            }
        }

        return null;

    }

}
