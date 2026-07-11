package com.kongrarainforest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.entity.SpawnGroup;

public class KongraRainforestMod implements ModInitializer {
    public static final String MOD_ID = "kongrarainforest";

    @Override
    public void onInitialize() {
        KongraRainforestModItems.register();
        KongraRainforestModEntities.register();
        RainDamageHandler.register();

        // Add rainforest animal spawns to jungle biomes
        BiomeModifications.addSpawnEntry(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                SpawnGroup.CREATURE, KongraRainforestModEntities.RAINFOREST_JAGUAR, 8, 1, 2);
        BiomeModifications.addSpawnEntry(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                SpawnGroup.CREATURE, KongraRainforestModEntities.RAINFOREST_TOUCAN, 10, 1, 3);
        BiomeModifications.addSpawnEntry(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                SpawnGroup.CREATURE, KongraRainforestModEntities.RAINFOREST_TAPIR, 6, 1, 2);
        BiomeModifications.addSpawnEntry(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                SpawnGroup.MONSTER, KongraRainforestModEntities.KONGRA, 2, 1, 1);
    }
}