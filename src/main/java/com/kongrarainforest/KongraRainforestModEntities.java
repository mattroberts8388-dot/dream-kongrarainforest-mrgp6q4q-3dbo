package com.kongrarainforest;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class KongraRainforestModEntities {

    public static final EntityType<KongraEntity> KONGRA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(KongraRainforestMod.MOD_ID, "kongra"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KongraEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4f, 2.8f)).build());

    public static final EntityType<RainforestJaguarEntity> RAINFOREST_JAGUAR = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(KongraRainforestMod.MOD_ID, "rainforest_jaguar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainforestJaguarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());

    public static final EntityType<RainforestToucanEntity> RAINFOREST_TOUCAN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(KongraRainforestMod.MOD_ID, "rainforest_toucan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainforestToucanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.7f)).build());

    public static final EntityType<RainforestTapirEntity> RAINFOREST_TAPIR = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(KongraRainforestMod.MOD_ID, "rainforest_tapir"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainforestTapirEntity::new)
                    .dimensions(EntityDimensions.fixed(1.1f, 1.1f)).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(KONGRA, KongraEntity.createKongraAttributes());
        FabricDefaultAttributeRegistry.register(RAINFOREST_JAGUAR, RainforestJaguarEntity.createJaguarAttributes());
        FabricDefaultAttributeRegistry.register(RAINFOREST_TOUCAN, RainforestToucanEntity.createToucanAttributes());
        FabricDefaultAttributeRegistry.register(RAINFOREST_TAPIR, RainforestTapirEntity.createTapirAttributes());
    }
}