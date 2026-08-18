package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet208SetDisplayObjective extends Packet
{
    
    public int scoreboardPosition;

    
    public String scoreName;

    public Packet208SetDisplayObjective() {}

    public Packet208SetDisplayObjective(int par1, ScoreObjective par2ScoreObjective)
    {
        this.scoreboardPosition = par1;

        if (par2ScoreObjective == null)
        {
            this.scoreName = "";
        }
        else
        {
            this.scoreName = par2ScoreObjective.getName();
        }
    }

    


    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.scoreboardPosition = par1DataInputStream.readByte();
        this.scoreName = readString(par1DataInputStream, 16);
    }

    


    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte(this.scoreboardPosition);
        writeString(this.scoreName, par1DataOutputStream);
    }

    


    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSetDisplayObjective(this);
    }

    


    public int getPacketSize()
    {
        return 3 + this.scoreName.length();
    }
}
