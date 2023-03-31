package com.tristankechlo.livingthings.init;

import com.tristankechlo.livingthings.LivingThings;
import com.tristankechlo.livingthings.entity.PenguinEntity;
import com.tristankechlo.livingthings.platform.RegistrationProvider;
import com.tristankechlo.livingthings.platform.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class ModEntities {

    public static void init() {}

    public static final RegistrationProvider<EntityType<?>> ENTITY_TYPES = RegistrationProvider.get(Registry.ENTITY_TYPE, LivingThings.MOD_ID);

    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITY_TYPES.register("penguin", () -> create("penguin", PenguinEntity::new, MobCategory.CREATURE, 0.8F, 1.45F));

    // create standard entity type
    private static <T extends Entity> EntityType<T> create(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return EntityType.Builder.of(factory, category).sized(width, height).build(LivingThings.MOD_ID + ":" + name);
    }

}
