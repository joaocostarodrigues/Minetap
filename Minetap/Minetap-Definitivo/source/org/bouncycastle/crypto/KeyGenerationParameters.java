package org.bouncycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters
{
    private SecureRandom random;
    private int strength;

    public KeyGenerationParameters(SecureRandom par1SecureRandom, int par2)
    {
        this.random = par1SecureRandom;
        this.strength = par2;
    }

    


    public SecureRandom getRandom()
    {
        return this.random;
    }

    


    public int getStrength()
    {
        return this.strength;
    }
}
