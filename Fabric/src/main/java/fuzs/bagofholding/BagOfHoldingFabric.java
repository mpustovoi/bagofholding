package fuzs.bagofholding;

import fuzs.bagofholding.init.FabricModRegistry;
import fuzs.bagofholding.init.ModRegistry;
import fuzs.puzzleslib.core.CoreServices;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.level.ServerPlayer;

public class BagOfHoldingFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CoreServices.FACTORIES.modConstructor(BagOfHolding.MOD_ID).accept(new BagOfHolding());
        FabricModRegistry.touch();
        registerHandlers();
    }

    private static void registerHandlers() {
        ServerPlayerEvents.COPY_FROM.register((ServerPlayer oldPlayer, ServerPlayer newPlayer, boolean alive) -> {
            if (alive) return;
            ModRegistry.BAG_PERSEVERANCE_CAPABILITY.maybeGet(oldPlayer).ifPresent(capability -> {
                capability.restoreAfterRespawn(newPlayer);
            });
        });
    }
}