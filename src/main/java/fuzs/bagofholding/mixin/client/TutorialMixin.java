package fuzs.bagofholding.mixin.client;

import fuzs.bagofholding.client.tutorial.ContainerItemTutorial;
import fuzs.bagofholding.world.item.BagItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Tutorial.class)
public class TutorialMixin {
    @Unique
    private ContainerItemTutorial bagItemTutorial;
    @Unique
    private ContainerItemTutorial shulkerBoxItemTutorial;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(Minecraft p_175022_, Options p_175023_, CallbackInfo callbackInfo) {
        this.bagItemTutorial = new ContainerItemTutorial((Tutorial) (Object) this, p_175023_, stack -> stack.getItem() instanceof BagItem);
        this.shulkerBoxItemTutorial = new ContainerItemTutorial((Tutorial) (Object) this, p_175023_, stack -> Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock);
    }

    @Inject(method = "onInventoryAction", at = @At("TAIL"))
    public void onInventoryAction(ItemStack p_175025_, ItemStack p_175026_, ClickAction p_175027_, CallbackInfo callbackInfo) {
        this.bagItemTutorial.onInventoryAction(p_175025_, p_175026_, p_175027_);
        this.shulkerBoxItemTutorial.onInventoryAction(p_175025_, p_175026_, p_175027_);
    }
}
