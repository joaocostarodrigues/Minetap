package net.minecraft.src;

class InventoryRepair extends InventoryBasic
{
    
    final ContainerRepair theContainer;

    InventoryRepair(ContainerRepair par1ContainerRepair, String par2Str, boolean par3, int par4)
    {
        super(par2Str, par3, par4);
        this.theContainer = par1ContainerRepair;
    }

    


    public void onInventoryChanged()
    {
        super.onInventoryChanged();
        this.theContainer.onCraftMatrixChanged(this);
    }

    


    public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }
}
