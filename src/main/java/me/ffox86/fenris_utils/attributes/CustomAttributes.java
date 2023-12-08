package me.ffox86.fenris_utils.attributes;

import java.util.HashMap;
import java.util.Map;

public class CustomAttributes {
    public static final Map<String, CustomAttribute> all = new HashMap<>();

    public static void createAttribute(String name, float default_val, float min_val, float max_val) {
        all.put(name, new CustomAttribute(name, default_val, min_val, max_val));
    }

    static {
        createAttribute("fire_resistance", 0, 0, 1024);
    }
}
