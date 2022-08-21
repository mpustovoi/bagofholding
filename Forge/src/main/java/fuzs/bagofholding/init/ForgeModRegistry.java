package fuzs.bagofholding.init;

import fuzs.bagofholding.BagOfHolding;
import fuzs.bagofholding.config.ServerConfig;
import fuzs.bagofholding.world.inventory.BagItemMenu;
import fuzs.bagofholding.world.item.ForgeBagOfHoldingItem;
import fuzs.puzzleslib.core.CoreServices;
import fuzs.puzzleslib.init.RegistryManager;
import fuzs.puzzleslib.init.RegistryReference;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class ForgeModRegistry {
    private static final RegistryManager REGISTRY = CoreServices.FACTORIES.registration(BagOfHolding.MOD_ID);
    public static final RegistryReference<Item> LEATHER_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("leather_bag_of_holding", () -> new ForgeBagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.get(ServerConfig.class).leatherBagRows, DyeColor.BROWN, BagItemMenu::leatherBag));
    public static final RegistryReference<Item> IRON_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("iron_bag_of_holding", () -> new ForgeBagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.get(ServerConfig.class).ironBagRows, DyeColor.WHITE, BagItemMenu::ironBag));
    public static final RegistryReference<Item> GOLDEN_BAG_OF_HOLDING_ITEM = REGISTRY.registerItem("golden_bag_of_holding", () -> new ForgeBagOfHoldingItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1), () -> BagOfHolding.CONFIG.get(ServerConfig.class).goldenBagRows, DyeColor.YELLOW, BagItemMenu::goldenBag));

    public static void touch() {

    }
}
