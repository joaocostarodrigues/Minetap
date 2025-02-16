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
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.capabilities.isFlying = true;
			
			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.thePlayer.motionY += 0.2;
			}
			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.thePlayer.motionY -= 0.2f;
			}
			if(mc.gameSettings.keyBindForward.isPressed()) {
				mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
			}
			super.onDisable();
		}
	}
 }
