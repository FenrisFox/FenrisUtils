package me.ffox86.fenris_utils.mixin;

import net.minecraft.commands.CommandSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.entity.EntityAccess;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// @Mixin(Entity.class)
abstract class EntityMixin implements Nameable, EntityAccess, CommandSource {

    public EntityMixin() {
        super();
    }

    /*@Inject(
            at = @At("TAIL"),
            method = "fireImmune"
    )*/
    private static void addFireImmuneAttributeCheck(final CallbackInfoReturnable<AttributeSupplier.Builder> info) {

    }
}
