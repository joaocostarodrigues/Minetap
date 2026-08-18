package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class Packet252SharedKey extends Packet
{
    private byte[] sharedSecret = new byte[0];
    private byte[] verifyToken = new byte[0];

    


    private SecretKey sharedKey;

    public Packet252SharedKey() {}

    public Packet252SharedKey(SecretKey par1SecretKey, PublicKey par2PublicKey, byte[] par3ArrayOfByte)
    {
        this.sharedKey = par1SecretKey;
        this.sharedSecret = CryptManager.encryptData(par2PublicKey, par1SecretKey.getEncoded());
        this.verifyToken = CryptManager.encryptData(par2PublicKey, par3ArrayOfByte);
    }

    


    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.sharedSecret = readBytesFromStream(par1DataInputStream);
        this.verifyToken = readBytesFromStream(par1DataInputStream);
    }

    


    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeByteArray(par1DataOutputStream, this.sharedSecret);
        writeByteArray(par1DataOutputStream, this.verifyToken);
    }

    


    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSharedKey(this);
    }

    


    public int getPacketSize()
    {
        return 2 + this.sharedSecret.length + 2 + this.verifyToken.length;
    }

    


    public SecretKey getSharedKey(PrivateKey par1PrivateKey)
    {
        return par1PrivateKey == null ? this.sharedKey : (this.sharedKey = CryptManager.decryptSharedKey(par1PrivateKey, this.sharedSecret));
    }

    


    public SecretKey getSharedKey()
    {
        return this.getSharedKey((PrivateKey)null);
    }

    


    public byte[] getVerifyToken(PrivateKey par1PrivateKey)
    {
        return par1PrivateKey == null ? this.verifyToken : CryptManager.decryptData(par1PrivateKey, this.verifyToken);
    }
}
