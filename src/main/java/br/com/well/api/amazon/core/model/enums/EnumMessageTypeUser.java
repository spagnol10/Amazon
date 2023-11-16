package br.com.well.api.amazon.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMessageTypeUser {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    CREATE_ADDRESS("CREATE_ADDRESS"),
    UPDATE_ADDRESS("UPDATE_ADDRESS"),
    DELETE_ADDRESS("DELETE_ADDRESS");

    private String key;

    public static EnumMessageTypeUser getEnumIfExists(String msg) {

        for (EnumMessageTypeUser enumValue : EnumMessageTypeUser.values()) {
            if (enumValue.getKey().equalsIgnoreCase(msg)) {
                return enumValue;
            }
        }

        return null;
    }
}
