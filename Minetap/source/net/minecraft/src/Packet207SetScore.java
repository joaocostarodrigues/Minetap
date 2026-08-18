package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet207SetScore extends Packet
{
    
    public String itemName = "";

    


    public String scoreName = "";

    


    public int value = 0;

    
    public int updateOrRemove = 0;

    public Packet207SetScore() {}

    public Packet207SetScore(Score par1, int par2)
    {
        this.itemName = par1.func_96653_e();
        this.scoreName = par1.func_96645_d().getName();
        this.value = par1.func_96652_c();
        this.updateOrRemove = par2;
    }

    public Packet207SetScore(String par1)
    {
        this.itemName = par1;
        this.scoreName = "";
        this.value = 0;
        this.updateOrRemove = 1;
    }

    


    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.itemName = readString(par1DataInputStream, 16);
        this.updateOrRemove = par1DataInputStream.readByte();

        if (this.updateOrRemove != 1)
        {
            this.scoreName = readString(par1DataInputStream, 16);
            this.value = par1DataInputStream.readInt();
        }
    }

    


    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeString(this.itemName, par1DataOutputStream);
        par1DataOutputStream.writeByte(this.updateOrRemove);

        if (this.updateOrRemove != 1)
        {
            writeString(this.scoreName, par1DataOutputStream);
            par1DataOutputStream.writeInt(this.value);
        }
    }

    


    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSetScore(this);
    }

    


    public int getPacketSize()
    {
        return 2 + this.itemName.length() + 2 + this.scoreName.length() + 4 + 1;
    }
}
