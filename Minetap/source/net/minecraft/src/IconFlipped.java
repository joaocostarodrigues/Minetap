package net.minecraft.src;

public class IconFlipped implements Icon
{
    private final Icon baseIcon;
    private final boolean flipU;
    private final boolean flipV;

    public IconFlipped(Icon par1Icon, boolean par2, boolean par3)
    {
        this.baseIcon = par1Icon;
        this.flipU = par2;
        this.flipV = par3;
    }

    


    public int getOriginX()
    {
        return this.baseIcon.getOriginX();
    }

    


    public int getOriginY()
    {
        return this.baseIcon.getOriginY();
    }

    


    public float getMinU()
    {
        return this.flipU ? this.baseIcon.getMaxU() : this.baseIcon.getMinU();
    }

    


    public float getMaxU()
    {
        return this.flipU ? this.baseIcon.getMinU() : this.baseIcon.getMaxU();
    }

    


    public float getInterpolatedU(double par1)
    {
        float var3 = this.getMaxU() - this.getMinU();
        return this.getMinU() + var3 * ((float)par1 / 16.0F);
    }

    


    public float getMinV()
    {
        return this.flipV ? this.baseIcon.getMinV() : this.baseIcon.getMinV();
    }

    


    public float getMaxV()
    {
        return this.flipV ? this.baseIcon.getMinV() : this.baseIcon.getMaxV();
    }

    


    public float getInterpolatedV(double par1)
    {
        float var3 = this.getMaxV() - this.getMinV();
        return this.getMinV() + var3 * ((float)par1 / 16.0F);
    }

    public String getIconName()
    {
        return this.baseIcon.getIconName();
    }

    


    public int getSheetWidth()
    {
        return this.baseIcon.getSheetWidth();
    }

    


    public int getSheetHeight()
    {
        return this.baseIcon.getSheetHeight();
    }
}
