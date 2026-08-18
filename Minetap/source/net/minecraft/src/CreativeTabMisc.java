package net.minecraft.src;

import java.util.List;

final class CreativeTabMisc extends CreativeTabs
{
    CreativeTabMisc(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    


    public int getTabIconItemIndex()
    {
        return Item.bucketLava.itemID;
    }

    


    public void displayAllReleventItems(List par1List)
    {
        super.displayAllReleventItems(par1List);
        this.func_92116_a(par1List, new EnumEnchantmentType[] {EnumEnchantmentType.all});
    }
}
