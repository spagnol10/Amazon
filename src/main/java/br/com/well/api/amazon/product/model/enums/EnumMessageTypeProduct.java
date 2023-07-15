package br.com.well.api.amazon.product.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMessageTypeProduct {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private final String key;

    public static EnumMessageTypeProduct getEnumIfExists(String e) {

        for (EnumMessageTypeProduct enumValue : EnumMessageTypeProduct.values()) {
            if (enumValue.getKey().equalsIgnoreCase(e)) {
                return enumValue;
            }
        }

        return null;
    }

}
