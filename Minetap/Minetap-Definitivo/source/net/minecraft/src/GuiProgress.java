package net.minecraft.src;

public class GuiProgress extends GuiScreen implements IProgressUpdate
{
    private String progressMessage = "";
    private String workingMessage = "";
    private int currentProgress = 0;
    private boolean noMoreProgress;

    


    public void displayProgressMessage(String par1Str)
    {
        this.resetProgressAndMessage(par1Str);
    }

    



    public void resetProgressAndMessage(String par1Str)
    {
        this.progressMessage = par1Str;
        this.resetProgresAndWorkingMessage("Working...");
    }

    


    public void resetProgresAndWorkingMessage(String par1Str)
    {
        this.workingMessage = par1Str;
        this.setLoadingProgress(0);
    }

    


    public void setLoadingProgress(int par1)
    {
        this.currentProgress = par1;
    }

    


    public void onNoMoreProgress()
    {
        this.noMoreProgress = true;
    }

    


    public void drawScreen(int par1, int par2, float par3)
    {
        if (this.noMoreProgress)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else
        {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRenderer, this.progressMessage, this.width / 2, 70, 16777215);
            this.drawCenteredString(this.fontRenderer, this.workingMessage + " " + this.currentProgress + "%", this.width / 2, 90, 16777215);
            super.drawScreen(par1, par2, par3);
        }
    }
}
