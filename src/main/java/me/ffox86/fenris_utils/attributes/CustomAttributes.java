package me.ffox86.fenris_utils.attributes;

import me.ffox86.fenris_utils.FenrisUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CustomAttributes {
    FIRE_RESISTANCE("fire_resistance", 0, 0, 1024);

    public final CustomAttribute attribute;
    public final String name;
    public final String ID;

    CustomAttributes(String name, float default_val, float min_val, float max_val) {
        this.attribute = new CustomAttribute(name, default_val, min_val, max_val);
        this.name = name;
        this.ID = FenrisUtils.getIdentifier(name);
    }

    public static final Map<String, CustomAttribute> all = new HashMap<>();
    static {
        for (CustomAttributes attribute1: EnumSet.allOf(CustomAttributes.class)) {
            CustomAttributes.all.put(attribute1.name(), attribute1.attribute);
        }
    }
}
