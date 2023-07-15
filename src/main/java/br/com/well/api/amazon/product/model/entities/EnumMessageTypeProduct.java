package br.com.well.api.amazon.product.model.entities;

import br.com.well.api.amazon.user.model.enums.EnumMessageTypeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMessageTypeProduct {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private final String key;

    public static EnumMessageTypeUser getEnumIfExists(String msg) {

        for (EnumMessageTypeUser enumValue : EnumMessageTypeUser.values()) {
            if (enumValue.getKey().equalsIgnoreCase(msg)) {
                return enumValue;
            }
        }

        return null;
    }
}
