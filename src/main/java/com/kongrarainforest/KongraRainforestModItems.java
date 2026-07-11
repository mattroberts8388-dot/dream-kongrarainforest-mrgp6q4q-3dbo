package com.kongrarainforest;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class KongraRainforestModItems {

    public static final FoodComponent JUNGLE_FRUIT_FOOD = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.8f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0f)
            .build();

    // Crafting materials (the hardest items to find in the rainforest)
    public static final Item KONGRA_SCALE = new Item(new Item.Settings());
    public static final Item RAINFOREST_RESIN = new Item(new Item.Settings());
    public static final Item VENOM_GLAND = new Item(new Item.Settings());
    public static final Item JUNGLE_FRUIT = new Item(new Item.Settings().food(JUNGLE_FRUIT_FOOD));

    // Camouflage KONGRA armor
    public static final Item KONGRA_HELMET = new ArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item KONGRA_CHESTPLATE = new ArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item KONGRA_LEGGINGS = new ArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item KONGRA_BOOTS = new ArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static void register() {
        reg("kongra_scale", KONGRA_SCALE);
        reg("rainforest_resin", RAINFOREST_RESIN);
        reg("venom_gland", VENOM_GLAND);
        reg("jungle_fruit", JUNGLE_FRUIT);
        reg("kongra_helmet", KONGRA_HELMET);
        reg("kongra_chestplate", KONGRA_CHESTPLATE);
        reg("kongra_leggings", KONGRA_LEGGINGS);
        reg("kongra_boots", KONGRA_BOOTS);
    }

    private static void reg(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(KongraRainforestMod.MOD_ID, name), item);
    }
}