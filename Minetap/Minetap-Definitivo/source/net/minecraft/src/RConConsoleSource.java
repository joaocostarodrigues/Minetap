package net.minecraft.src;

public class RConConsoleSource implements ICommandSender
{
    
    public static final RConConsoleSource consoleBuffer = new RConConsoleSource();

    
    private StringBuffer buffer = new StringBuffer();

    


    public void resetLog()
    {
        this.buffer.setLength(0);
    }

    public String getChatBuffer()
    {
        return this.buffer.toString();
    }

    


    public String getCommandSenderName()
    {
        return "Rcon";
    }

    public void sendChatToPlayer(String par1Str)
    {
        this.buffer.append(par1Str);
    }

    


    public boolean canCommandSenderUseCommand(int par1, String par2Str)
    {
        return true;
    }

    


    public String translateString(String par1Str, Object ... par2ArrayOfObj)
    {
        return StringTranslate.getInstance().translateKeyFormat(par1Str, par2ArrayOfObj);
    }

    


    public ChunkCoordinates getPlayerCoordinates()
    {
        return new ChunkCoordinates(0, 0, 0);
    }
}
