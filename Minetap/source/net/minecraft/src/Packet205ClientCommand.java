package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet205ClientCommand extends Packet
{
    


    public int forceRespawn;

    public Packet205ClientCommand() {}

    public Packet205ClientCommand(int par1)
    {
        this.forceRespawn = par1;
    }

    


    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.forceRespawn = par1DataInputStream.readByte();
    }

    


    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte(this.forceRespawn & 255);
    }

    


    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleClientCommand(this);
    }

    


    public int getPacketSize()
    {
        return 1;
    }
}
