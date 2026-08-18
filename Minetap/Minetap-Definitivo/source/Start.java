import java.io.File;
import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;

public class Start
{
    public static void main(String[] args)
    {
        String nickname = System.getenv("MINETAP_USERNAME");
        if (nickname != null && nickname.matches("[A-Za-z0-9_]{3,16}"))
        {
            if (args.length == 0)
            {
                args = new String[] {nickname, "-"};
            }
            else
            {
                args[0] = nickname;
            }
        }

        try
        {
            Field f = Minecraft.class.getDeclaredField("minecraftDir");
            Field.setAccessible(new Field[] { f }, true);
            f.set(null, new File("."));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        Minecraft.main(args);
    }
}
