package br.com.well.api.amazon.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPlateCategory {

    LOW_CARB("LOW_CARB", "Low Carb"),
    TRANS_FATS_FREE("TRANS_FATS_FREE", "Sem Gorduras Trans"),
    LACTOSE_FREE("LACTOSE_FREE", "Sem Lactose"),
    HIGH_PROTEIN("HIGH_PROTEIN", "Rico em Proteína"),
    NO_GLUTEN("NO_GLUTEN", "Sem Glúten"),
    VEGAN("VEGAN", "Vegano"),
    VEGETARIAN("VEGETARIAN", "Vegetariano");

    private final String key;
    private final String value;

    public static Boolean containsSize(String size) {

        for (EnumPlateCategory enumValue : EnumPlateCategory.values()) {
            if (enumValue.getKey().equalsIgnoreCase(size)) {
                return true;
            }
        }

        return false;
    }

}
