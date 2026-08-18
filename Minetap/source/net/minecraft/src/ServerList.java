package net.minecraft.src;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;

public class ServerList
{
    
    private final Minecraft mc;

    
    private final List servers = new ArrayList();

    public ServerList(Minecraft par1Minecraft)
    {
        this.mc = par1Minecraft;
        this.loadServerList();
    }

    



    public void loadServerList()
    {
        try
        {
            NBTTagCompound var1 = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            NBTTagList var2 = var1.getTagList("servers");
            this.servers.clear();

            for (int var3 = 0; var3 < var2.tagCount(); ++var3)
            {
                this.servers.add(ServerData.getServerDataFromNBTCompound((NBTTagCompound)var2.tagAt(var3)));
            }
        }
        catch (Exception var4)
        {
            var4.printStackTrace();
        }
    }

    



    public void saveServerList()
    {
        try
        {
            NBTTagList var1 = new NBTTagList();
            Iterator var2 = this.servers.iterator();

            while (var2.hasNext())
            {
                ServerData var3 = (ServerData)var2.next();
                var1.appendTag(var3.getNBTCompound());
            }

            NBTTagCompound var5 = new NBTTagCompound();
            var5.setTag("servers", var1);
            CompressedStreamTools.safeWrite(var5, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception var4)
        {
            var4.printStackTrace();
        }
    }

    


    public ServerData getServerData(int par1)
    {
        return (ServerData)this.servers.get(par1);
    }

    


    public void removeServerData(int par1)
    {
        this.servers.remove(par1);
    }

    


    public void addServerData(ServerData par1ServerData)
    {
        this.servers.add(par1ServerData);
    }

    


    public int countServers()
    {
        return this.servers.size();
    }

    


    public void swapServers(int par1, int par2)
    {
        ServerData var3 = this.getServerData(par1);
        this.servers.set(par1, this.getServerData(par2));
        this.servers.set(par2, var3);
        this.saveServerList();
    }

    


    public void setServer(int par1, ServerData par2ServerData)
    {
        this.servers.set(par1, par2ServerData);
    }

    public static void func_78852_b(ServerData par0ServerData)
    {
        ServerList var1 = new ServerList(Minecraft.getMinecraft());
        var1.loadServerList();

        for (int var2 = 0; var2 < var1.countServers(); ++var2)
        {
            ServerData var3 = var1.getServerData(var2);

            if (var3.serverName.equals(par0ServerData.serverName) && var3.serverIP.equals(par0ServerData.serverIP))
            {
                var1.setServer(var2, par0ServerData);
                break;
            }
        }

        var1.saveServerList();
    }
}
