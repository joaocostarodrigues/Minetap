package me.sempre234.ocipe.module.player;

import org.lwjgl.input.Keyboard;
import me.sempre234.ocipe.module.Category;
import me.sempre234.ocipe.module.Module;

public class FallDamege extends Module {

    public static boolean enabled;

    public FallDamege() {
        super("FallDamege", Keyboard.KEY_V, Category.PLAYER);
        enabled = false;
    }

    public void onEnable() {
        enabled = true;
        if (mc.thePlayer != null) {
            mc.thePlayer.fallDistance = 0.0F;
        }
        super.onEnable();
    }

    public void onDisable() {
        enabled = false;
        super.onDisable();
    }

    public void onUpdate() {
        if (enabled && mc.thePlayer != null) {
            mc.thePlayer.fallDistance = 0.0F;
        }
        super.onUpdate();
    }
}
