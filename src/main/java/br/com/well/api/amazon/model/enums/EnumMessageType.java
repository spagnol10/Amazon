package br.com.well.api.amazon.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMessageType {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    CREATE_ADDRESS("CREATE_ADDRESS"),
    UPDATE_ADDRESS("UPDATE_ADDRESS"),
    DELETE_ADDRESS("DELETE_ADDRESS");

    private String key;

    public static EnumMessageType getEnumIfExists(String msg) {

        for (EnumMessageType enumValue : EnumMessageType.values()) {
            if (enumValue.getKey().equalsIgnoreCase(msg)) {
                return enumValue;
            }
        }

        return null;
    }
}
