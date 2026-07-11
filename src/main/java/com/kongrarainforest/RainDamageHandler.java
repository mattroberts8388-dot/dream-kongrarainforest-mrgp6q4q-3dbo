package com.kongrarainforest;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RainDamageHandler {

    // How long (in ticks) a player has been standing in the rain unprotected
    private static final Map<UUID, Integer> RAIN_EXPOSURE = new HashMap<>();

    // Grace period before rain begins to hurt (10 seconds = 200 ticks)
    private static final int GRACE_TICKS = 200;
    // Damage interval (every 2 seconds once past grace)
    private static final int DAMAGE_INTERVAL = 40;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                tickPlayer(player);
            }
        });
    }

    private static void tickPlayer(ServerPlayerEntity player) {
        UUID id = player.getUuid();

        boolean exposedToRain = player.getWorld().isRaining()
                && player.getWorld().isSkyVisible(player.getBlockPos())
                && !player.isSubmergedInWater()
                && !player.getWorld().getBiome(player.getBlockPos()).value().doesNotSnow(player.getBlockPos());

        if (!exposedToRain || isFullyProtected(player)) {
            RAIN_EXPOSURE.remove(id);
            return;
        }

        int exposure = RAIN_EXPOSURE.getOrDefault(id, 0) + 1;
        RAIN_EXPOSURE.put(id, exposure);

        if (exposure > GRACE_TICKS && (exposure - GRACE_TICKS) % DAMAGE_INTERVAL == 0) {
            if (!player.isCreative() && !player.isSpectator()) {
                // Damage escalates the longer you stay exposed
                float extra = MathHelper.clamp((exposure - GRACE_TICKS) / 600.0f, 0.0f, 3.0f);
                player.damage(player.getDamageSources().magic(), 1.0f + extra);
            }
        }
    }

    // KONGRA armor fully protects the player from rainforest rain
    private static boolean isFullyProtected(ServerPlayerEntity player) {
        return isKongra(player.getEquippedStack(EquipmentSlot.HEAD))
                && isKongra(player.getEquippedStack(EquipmentSlot.CHEST))
                && isKongra(player.getEquippedStack(EquipmentSlot.LEGS))
                && isKongra(player.getEquippedStack(EquipmentSlot.FEET));
    }

    private static boolean isKongra(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem armorItem
                && armorItem.getMaterial() == KongraArmorMaterial.INSTANCE;
    }

    // Keeps ItemEntity import meaningful without unused warnings suppression
    @SuppressWarnings("unused")
    private static boolean isItemEntity(Object o) {
        return o instanceof ItemEntity;
    }
}