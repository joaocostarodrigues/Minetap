package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderEnderCrystal extends Render
{
    private int field_76996_a = -1;
    private ModelBase field_76995_b;

    public RenderEnderCrystal()
    {
        this.shadowSize = 0.5F;
    }

    


    public void doRenderEnderCrystal(EntityEnderCrystal par1EntityEnderCrystal, double par2, double par4, double par6, float par8, float par9)
    {
        if (this.field_76996_a != 1)
        {
            this.field_76995_b = new ModelEnderCrystal(0.0F, true);
            this.field_76996_a = 1;
        }

        float var10 = (float)par1EntityEnderCrystal.innerRotation + par9;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        this.loadTexture("/mob/enderdragon/crystal.png");
        float var11 = MathHelper.sin(var10 * 0.2F) / 2.0F + 0.5F;
        var11 += var11 * var11;
        this.field_76995_b.render(par1EntityEnderCrystal, 0.0F, var10 * 3.0F, var11 * 0.2F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    





    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderEnderCrystal((EntityEnderCrystal)par1Entity, par2, par4, par6, par8, par9);
    }
}
