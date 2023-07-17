package br.com.well.api.amazon.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPlateSize {

    INDIVIDUAL("INDIVIDUAL", "Individual"),
    THREE_PEOPLE("THREE_PEOPLE", "3 Pessoas");

    private final String key;
    private final String value;

    public static Boolean containsSize(String size) {

        for (EnumPlateSize enumValue : EnumPlateSize.values()) {
            if (enumValue.getKey().equalsIgnoreCase(size)) {
                return true;
            }
        }

        return false;
    }
}
