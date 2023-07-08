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

    public static EnumMessageType getEnumIfExists(String e) {

        for (EnumMessageType enumValue : EnumMessageType.values()) {
            if (enumValue.getKey().equalsIgnoreCase(e)) {
                return enumValue;
            }
        }

        return null;
    }
}
