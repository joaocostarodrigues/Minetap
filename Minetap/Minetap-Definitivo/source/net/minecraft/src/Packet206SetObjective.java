package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet206SetObjective extends Packet
{
    public String objectiveName;
    public String objectiveDisplayName;

    


    public int change;

    public Packet206SetObjective() {}

    public Packet206SetObjective(ScoreObjective par1, int par2)
    {
        this.objectiveName = par1.getName();
        this.objectiveDisplayName = par1.getDisplayName();
        this.change = par2;
    }

    


    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.objectiveName = readString(par1DataInputStream, 16);
        this.objectiveDisplayName = readString(par1DataInputStream, 32);
        this.change = par1DataInputStream.readByte();
    }

    


    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeString(this.objectiveName, par1DataOutputStream);
        writeString(this.objectiveDisplayName, par1DataOutputStream);
        par1DataOutputStream.writeByte(this.change);
    }

    


    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSetObjective(this);
    }

    


    public int getPacketSize()
    {
        return 2 + this.objectiveName.length() + 2 + this.objectiveDisplayName.length() + 1;
    }
}
