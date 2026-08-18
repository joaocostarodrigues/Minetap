package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

public class CreativeCrafting implements ICrafting
{
    private final Minecraft mc;

    public CreativeCrafting(Minecraft par1)
    {
        this.mc = par1;
    }

    public void sendContainerAndContentsToPlayer(Container par1Container, List par2List) {}

    



    public void sendSlotContents(Container par1Container, int par2, ItemStack par3ItemStack)
    {
        this.mc.playerController.sendSlotPacket(par3ItemStack, par2);
    }

    




    public void sendProgressBarUpdate(Container par1Container, int par2, int par3) {}
}
