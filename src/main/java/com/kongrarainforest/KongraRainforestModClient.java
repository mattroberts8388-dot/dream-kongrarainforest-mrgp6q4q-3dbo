package com.kongrarainforest;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
public class KongraRainforestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(KongraRainforestModEntities.KONGRA, NoopRenderer::new);
        EntityRendererRegistry.register(KongraRainforestModEntities.RAINFOREST_JAGUAR, NoopRenderer::new);
        EntityRendererRegistry.register(KongraRainforestModEntities.RAINFOREST_TOUCAN, NoopRenderer::new);
        EntityRendererRegistry.register(KongraRainforestModEntities.RAINFOREST_TAPIR, NoopRenderer::new);
    }
    private static class NoopRenderer<T extends Entity> extends EntityRenderer<T> {
        NoopRenderer(EntityRendererFactory.Context ctx) { super(ctx); }
        @Override public Identifier getTexture(T e) { return new Identifier("minecraft", "textures/misc/unknown_server.png"); }
    }
}