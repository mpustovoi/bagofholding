package fuzs.bagofholding.network.message;

import fuzs.bagofholding.world.inventory.BagInventorySlot;
import fuzs.bagofholding.world.inventory.BagMenu;
import fuzs.puzzleslib.network.message.Message;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;

public class S2CLockSlotMessage implements Message {
    private int containerId;
    private int slotId;

    public S2CLockSlotMessage() {
    }

    public S2CLockSlotMessage(int containerId, int slotId) {
        this.containerId = containerId;
        this.slotId = slotId;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeByte(this.containerId);
        buf.writeByte(this.slotId);
    }

    @Override
    public void read(FriendlyByteBuf buf) {
        this.containerId = buf.readByte();
        this.slotId = buf.readByte();
    }

    @Override
    public LockSlotHandler makeHandler() {
        return new LockSlotHandler();
    }

    private static class LockSlotHandler extends PacketHandler<S2CLockSlotMessage> {
        @Override
        public void handle(S2CLockSlotMessage packet, Player player, Object gameInstance) {
            if (player.containerMenu.containerId == packet.containerId && player.containerMenu instanceof BagMenu menu) {
                ((BagInventorySlot) menu.getSlot(packet.slotId)).lock();
            }
        }
    }
}
