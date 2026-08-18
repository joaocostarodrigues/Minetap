package net.minecraft.src;

import java.util.ArrayList;
import me.sempre234.ocipe.module.Module;
import me.sempre234.ocipe.module.ModuleManager;
import org.lwjgl.input.Keyboard;

public class GuiMinetapMenu extends GuiScreen
{
    private static final int MASTER_BUTTON = 1;
    private static final int CLOSE_BUTTON = 2;
    private static final int CPS_BUTTON = 3;
    private static final int TOGGLE_BUTTON_BASE = 100;
    private static final int KEY_BUTTON_BASE = 200;
    private Module bindingModule;

    public void initGui()
    {
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        ArrayList<Module> modules = ModuleManager.getModules();
        this.buttonList.add(new GuiButton(MASTER_BUTTON, centerX - 107, centerY - 60, 144, 20, this.getMasterLabel()));
        this.buttonList.add(new GuiButton(CPS_BUTTON, centerX + 41, centerY - 60, 66, 20, this.getCpsLabel()));

        for (int index = 0; index < modules.size(); ++index)
        {
            Module module = modules.get(index);
            int y = centerY - 34 + index * 22;
            this.buttonList.add(new GuiButton(TOGGLE_BUTTON_BASE + index, centerX - 107, y, 130, 18, this.getModuleLabel(module)));
            this.buttonList.add(new GuiButton(KEY_BUTTON_BASE + index, centerX + 27, y, 80, 18, this.getKeyLabel(module)));
        }

        this.buttonList.add(new GuiButton(CLOSE_BUTTON, centerX - 65, centerY + 58, 130, 18, "Fechar menu"));
        this.refreshButtons();
    }

    protected void actionPerformed(GuiButton button)
    {
        ArrayList<Module> modules = ModuleManager.getModules();

        if (button.id == MASTER_BUTTON)
        {
            this.bindingModule = null;
            ModuleManager.toggleClient();
            this.refreshButtons();
        }
        else if (button.id == CLOSE_BUTTON)
        {
            this.closeMenu();
        }
        else if (button.id == CPS_BUTTON)
        {
            if (ModuleManager.isClientEnabled())
            {
                ModuleManager.toggleCps();
                this.refreshButtons();
            }
        }
        else if (button.id >= TOGGLE_BUTTON_BASE && button.id < TOGGLE_BUTTON_BASE + modules.size())
        {
            if (ModuleManager.isClientEnabled())
            {
                modules.get(button.id - TOGGLE_BUTTON_BASE).toggle();
                this.refreshButtons();
            }
        }
        else if (button.id >= KEY_BUTTON_BASE && button.id < KEY_BUTTON_BASE + modules.size())
        {
            this.bindingModule = modules.get(button.id - KEY_BUTTON_BASE);
            this.refreshButtons();
        }
    }

    protected void keyTyped(char character, int key)
    {
        if (this.bindingModule != null)
        {
            if (key == Keyboard.KEY_ESCAPE || key == Keyboard.KEY_INSERT)
            {
                this.bindingModule = null;
            }
            else if (key == Keyboard.KEY_BACK)
            {
                ModuleManager.setModuleKey(this.bindingModule, Keyboard.KEY_NONE);
                this.bindingModule = null;
            }
            else
            {
                ModuleManager.setModuleKey(this.bindingModule, key);
                this.bindingModule = null;
            }

            this.refreshButtons();
            return;
        }

        if (key == Keyboard.KEY_INSERT || key == Keyboard.KEY_ESCAPE)
        {
            this.closeMenu();
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        this.drawGradientRect(0, 0, this.width, this.height, -1879048192, -1610612736);
        drawRect(centerX - 137, centerY - 94, centerX + 137, centerY + 94, -15066598);
        drawRect(centerX - 135, centerY - 92, centerX + 135, centerY + 92, -15724528);
        drawRect(centerX - 135, centerY - 92, centerX + 135, centerY - 68, -13684945);
        this.drawCenteredString(this.fontRenderer, "MINETAP 1.2", centerX, centerY - 85, 16777215);
        this.drawCenteredString(this.fontRenderer, ModuleManager.isClientEnabled() ? "Recursos liberados" : "Modo normal: recursos bloqueados", centerX, centerY - 75, ModuleManager.isClientEnabled() ? 5635925 : 13421772);

        if (this.bindingModule != null)
        {
            this.drawCenteredString(this.fontRenderer, "Pressione uma tecla para " + this.bindingModule.getName(), centerX, centerY + 79, 16777120);
            this.drawCenteredString(this.fontRenderer, "BACKSPACE remove | ESC cancela", centerX, centerY + 87, 8947848);
        }
        else
        {
            this.drawCenteredString(this.fontRenderer, "TECLA altera o atalho | INSERT fecha", centerX, centerY + 82, 8947848);
        }

        super.drawScreen(mouseX, mouseY, partialTick);
    }

    public boolean doesGuiPauseGame()
    {
        return false;
    }

    private void refreshButtons()
    {
        ArrayList<Module> modules = ModuleManager.getModules();

        for (int index = 0; index < this.buttonList.size(); ++index)
        {
            GuiButton button = (GuiButton)this.buttonList.get(index);

            if (button.id == MASTER_BUTTON)
            {
                button.displayString = this.getMasterLabel();
            }
            else if (button.id == CPS_BUTTON)
            {
                button.displayString = this.getCpsLabel();
                button.enabled = ModuleManager.isClientEnabled();
            }
            else if (button.id >= TOGGLE_BUTTON_BASE && button.id < TOGGLE_BUTTON_BASE + modules.size())
            {
                button.displayString = this.getModuleLabel(modules.get(button.id - TOGGLE_BUTTON_BASE));
                button.enabled = ModuleManager.isClientEnabled();
            }
            else if (button.id >= KEY_BUTTON_BASE && button.id < KEY_BUTTON_BASE + modules.size())
            {
                button.displayString = this.getKeyLabel(modules.get(button.id - KEY_BUTTON_BASE));
            }
        }
    }

    private String getMasterLabel()
    {
        return ModuleManager.isClientEnabled() ? "MINETAP: LIGADO" : "MINETAP: DESLIGADO";
    }

    private String getModuleLabel(Module module)
    {
        return module.getName() + (module.isToggled() ? ": ATIVADO" : ": DESATIVADO");
    }

    private String getCpsLabel()
    {
        return ModuleManager.isCpsEnabled() ? "CPS: ON" : "CPS: OFF";
    }

    private String getKeyLabel(Module module)
    {
        if (this.bindingModule == module)
        {
            return "PRESSIONE...";
        }

        String keyName = Keyboard.getKeyName(module.getKey());
        return "TECLA: " + (keyName == null ? "NENHUMA" : keyName);
    }

    private void closeMenu()
    {
        this.bindingModule = null;
        this.mc.displayGuiScreen((GuiScreen)null);
        this.mc.setIngameFocus();
    }
}
