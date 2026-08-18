package net.minecraft.src;

public class GuiLanguage extends GuiScreen
{
    
    protected GuiScreen parentGui;

    



    private int updateTimer = -1;

    
    private GuiSlotLanguage languageList;

    
    private final GameSettings theGameSettings;

    
    private GuiSmallButton doneButton;

    public GuiLanguage(GuiScreen par1GuiScreen, GameSettings par2GameSettings)
    {
        this.parentGui = par1GuiScreen;
        this.theGameSettings = par2GameSettings;
    }

    


    public void initGui()
    {
        StringTranslate var1 = StringTranslate.getInstance();
        this.buttonList.add(this.doneButton = new GuiSmallButton(6, this.width / 2 - 75, this.height - 38, var1.translateKey("gui.done")));
        this.languageList = new GuiSlotLanguage(this);
        this.languageList.registerScrollButtons(this.buttonList, 7, 8);
    }

    


    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
                case 5:
                    break;

                case 6:
                    this.mc.displayGuiScreen(this.parentGui);
                    break;

                default:
                    this.languageList.actionPerformed(par1GuiButton);
            }
        }
    }

    


    public void drawScreen(int par1, int par2, float par3)
    {
        this.languageList.drawScreen(par1, par2, par3);

        if (this.updateTimer <= 0)
        {
            this.mc.texturePackList.updateAvaliableTexturePacks();
            this.updateTimer += 20;
        }

        StringTranslate var4 = StringTranslate.getInstance();
        this.drawCenteredString(this.fontRenderer, var4.translateKey("options.language"), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRenderer, "(" + var4.translateKey("options.languageWarning") + ")", this.width / 2, this.height - 56, 8421504);
        super.drawScreen(par1, par2, par3);
    }

    


    public void updateScreen()
    {
        super.updateScreen();
        --this.updateTimer;
    }

    


    static GameSettings getGameSettings(GuiLanguage par0GuiLanguage)
    {
        return par0GuiLanguage.theGameSettings;
    }

    


    static GuiSmallButton getDoneButton(GuiLanguage par0GuiLanguage)
    {
        return par0GuiLanguage.doneButton;
    }
}
