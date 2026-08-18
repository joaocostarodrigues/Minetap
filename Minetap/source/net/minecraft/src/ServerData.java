package net.minecraft.src;

public class ServerData
{
    public String serverName;
    public String serverIP;

    



    public String populationInfo;

    



    public String serverMOTD;

    
    public long pingToServer;
    public int field_82821_f = 61;

    
    public String gameVersion = "1.5.2";
    public boolean field_78841_f = false;
    private boolean field_78842_g = true;
    private boolean acceptsTextures = false;

    
    private boolean hideAddress = false;

    public ServerData(String par1Str, String par2Str)
    {
        this.serverName = par1Str;
        this.serverIP = par2Str;
    }

    


    public NBTTagCompound getNBTCompound()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        var1.setString("name", this.serverName);
        var1.setString("ip", this.serverIP);
        var1.setBoolean("hideAddress", this.hideAddress);

        if (!this.field_78842_g)
        {
            var1.setBoolean("acceptTextures", this.acceptsTextures);
        }

        return var1;
    }

    public boolean getAcceptsTextures()
    {
        return this.acceptsTextures;
    }

    public boolean func_78840_c()
    {
        return this.field_78842_g;
    }

    public void setAcceptsTextures(boolean par1)
    {
        this.acceptsTextures = par1;
        this.field_78842_g = false;
    }

    public boolean isHidingAddress()
    {
        return this.hideAddress;
    }

    public void setHideAddress(boolean par1)
    {
        this.hideAddress = par1;
    }

    


    public static ServerData getServerDataFromNBTCompound(NBTTagCompound par0NBTTagCompound)
    {
        ServerData var1 = new ServerData(par0NBTTagCompound.getString("name"), par0NBTTagCompound.getString("ip"));
        var1.hideAddress = par0NBTTagCompound.getBoolean("hideAddress");

        if (par0NBTTagCompound.hasKey("acceptTextures"))
        {
            var1.setAcceptsTextures(par0NBTTagCompound.getBoolean("acceptTextures"));
        }

        return var1;
    }
}
