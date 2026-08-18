package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderBat extends RenderLiving
{
    



    private int renderedBatSize;

    public RenderBat()
    {
        super(new ModelBat(), 0.25F);
        this.renderedBatSize = ((ModelBat)this.mainModel).getBatSize();
    }

    public void func_82443_a(EntityBat par1EntityBat, double par2, double par4, double par6, float par8, float par9)
    {
        int var10 = ((ModelBat)this.mainModel).getBatSize();

        if (var10 != this.renderedBatSize)
        {
            this.renderedBatSize = var10;
            this.mainModel = new ModelBat();
        }

        super.doRenderLiving(par1EntityBat, par2, par4, par6, par8, par9);
    }

    protected void func_82442_a(EntityBat par1EntityBat, float par2)
    {
        GL11.glScalef(0.35F, 0.35F, 0.35F);
    }

    protected void func_82445_a(EntityBat par1EntityBat, double par2, double par4, double par6)
    {
        super.renderLivingAt(par1EntityBat, par2, par4, par6);
    }

    protected void func_82444_a(EntityBat par1EntityBat, float par2, float par3, float par4)
    {
        if (!par1EntityBat.getIsBatHanging())
        {
            GL11.glTranslatef(0.0F, MathHelper.cos(par2 * 0.3F) * 0.1F, 0.0F);
        }
        else
        {
            GL11.glTranslatef(0.0F, -0.1F, 0.0F);
        }

        super.rotateCorpse(par1EntityBat, par2, par3, par4);
    }

    



    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.func_82442_a((EntityBat)par1EntityLiving, par2);
    }

    protected void rotateCorpse(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        this.func_82444_a((EntityBat)par1EntityLiving, par2, par3, par4);
    }

    


    protected void renderLivingAt(EntityLiving par1EntityLiving, double par2, double par4, double par6)
    {
        this.func_82445_a((EntityBat)par1EntityLiving, par2, par4, par6);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.func_82443_a((EntityBat)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    





    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.func_82443_a((EntityBat)par1Entity, par2, par4, par6, par8, par9);
    }
}
