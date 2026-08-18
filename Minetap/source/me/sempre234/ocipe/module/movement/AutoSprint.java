package me.sempre234.ocipe.module.movement;

import org.lwjgl.input.Keyboard;

import me.sempre234.ocipe.module.Category;
import me.sempre234.ocipe.module.Module;

public class AutoSprint extends Module{
	public AutoSprint() {
		super("AutoSprint", Keyboard.KEY_F, Category.MOVEMENT);
	}
	
	public void onEnable() {
		if (mc.thePlayer != null) {
			mc.thePlayer.setSprinting(true);
		}
		super.onEnable();
	}
	public void onUpdate() {
		if (this.isToggled() && mc.thePlayer != null && mc.gameSettings.keyBindForward.pressed) {
			mc.thePlayer.setSprinting(true);
		}
		super.onUpdate();
	}
	public void onDisable() {
		if (mc.thePlayer != null) {
			mc.thePlayer.setSprinting(false);
		}
		super.onDisable();
	}
}
