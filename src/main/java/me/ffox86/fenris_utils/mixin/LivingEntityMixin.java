package me.ffox86.fenris_utils.mixin;

import me.ffox86.fenris_utils.attributes.CustomAttributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(final EntityType<?> entityType, final Level level) {
        super(entityType, level);
    }

    @Inject(
            at = @At("RETURN"),
            method = "createLivingAttributes"
    )
    private static void addAttributes(final CallbackInfoReturnable<AttributeSupplier.Builder> info) {
        for (Map.Entry<String, ? extends Attribute> entry: CustomAttributes.all.entrySet()) {
            Attribute attribute = entry.getValue();
            info.getReturnValue().add(attribute);
        }
    }

    /*
    * Reduce incoming damage according to the attribute "fire_resistance" if it is fire damage.
    * */
    @ModifyVariable(
            at = @At("HEAD"), method = "hurt", ordinal = 0, argsOnly = true
    )
    private float addFireResistance(float b, DamageSource damageSource) {
        if (damageSource.isFire()) {
            return b * (1 - (float)((LivingEntity)(Object)this).getAttribute(
                    CustomAttributes.all.get("fire_resistance")).getValue()
            );
        }
        return b;
    }

    public boolean fireImmune() {
        if (((LivingEntity)(Object)this).getAttribute(CustomAttributes.all.get("fire_resistance")).getValue() >= 1) {
            return true;
        }
        return this.getType().fireImmune();
    }
}
