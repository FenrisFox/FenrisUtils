package me.ffox86.fenris_utils;

import me.ffox86.fenris_utils.attributes.CustomAttribute;
import me.ffox86.fenris_utils.attributes.CustomAttributes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

import java.util.Map;

public class FenrisUtils implements ModInitializer {
    public static final String ID = "fenris_utils";
    public static final String getIdentifier(String name) {return ID + ":" + (name).toLowerCase();}

    private static boolean registeredAttributes = false;
    public static void registerAttributes() {
        if (registeredAttributes) {
            return;
        }
        for(Map.Entry<String, CustomAttribute> entry: CustomAttributes.all.entrySet()) {
            Registry.register(Registry.ATTRIBUTE, entry.getValue().id, entry.getValue());
        }
        registeredAttributes = true;
    }

    @Override
    public void onInitialize() {
        FenrisUtils.registerAttributes();
    }
}
