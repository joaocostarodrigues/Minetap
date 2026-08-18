package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ConvertingProgressUpdate implements IProgressUpdate
{
    private long field_96245_b;

    
    final MinecraftServer mcServer;

    public ConvertingProgressUpdate(MinecraftServer par1)
    {
        this.mcServer = par1;
        this.field_96245_b = System.currentTimeMillis();
    }

    


    public void displayProgressMessage(String par1Str) {}

    



    public void resetProgressAndMessage(String par1Str) {}

    


    public void setLoadingProgress(int par1)
    {
        if (System.currentTimeMillis() - this.field_96245_b >= 1000L)
        {
            this.field_96245_b = System.currentTimeMillis();
            this.mcServer.getLogAgent().logInfo("Converting... " + par1 + "%");
        }
    }

    


    public void onNoMoreProgress() {}

    


    public void resetProgresAndWorkingMessage(String par1Str) {}
}
