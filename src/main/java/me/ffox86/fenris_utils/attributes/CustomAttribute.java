package me.ffox86.fenris_utils.attributes;

import me.ffox86.fenris_utils.FenrisUtils;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.UUID;

public class CustomAttribute extends RangedAttribute {
    public final String name;
    public final UUID uuid;
    public final String id;

    public CustomAttribute(String name, Float default_val, Float min_val, Float max_val) {
        super(name, default_val, min_val, max_val);
        this.name = name;
        this.id = FenrisUtils.getIdentifier(name);
        this.uuid = UUID.nameUUIDFromBytes(this.id.getBytes());
    }
}
