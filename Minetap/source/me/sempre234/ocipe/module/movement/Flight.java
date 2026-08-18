package me.sempre234.ocipe.module.movement;

import org.lwjgl.input.Keyboard;

import me.sempre234.ocipe.module.Category;
import me.sempre234.ocipe.module.Module;

public class Flight extends Module {
	public static float flyHackSpeed = 0.1f;
	
	public Flight() {
		super("Flight", Keyboard.KEY_C, Category.MOVEMENT);
	}
	
	public void onDisable() {
		if (mc.thePlayer != null) {
			mc.thePlayer.capabilities.isFlying = false;
			mc.thePlayer.capabilities.setFlySpeed(0.05f);
		}
		super.onDisable();
	}
	public void onUpdate() {
		if (this.isToggled() && mc.thePlayer != null) {
			mc.thePlayer.capabilities.isFlying = true;
			mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
			if (mc.gameSettings.keyBindJump.pressed) {
				mc.thePlayer.motionY = 0.2D;
			}
			if (mc.gameSettings.keyBindSneak.pressed) {
				mc.thePlayer.motionY = -0.2D;
			}
			if (!mc.gameSettings.keyBindJump.pressed && !mc.gameSettings.keyBindSneak.pressed) {
				mc.thePlayer.motionY = 0.0D;
			}
		}
		super.onUpdate();
	}
 }
