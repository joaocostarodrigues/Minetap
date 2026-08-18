package me.sempre234.ocipe.module.render;

import org.lwjgl.input.Keyboard;

import me.sempre234.ocipe.module.Module;

public class Xray extends Module{
	
	public static boolean enabled;
	private float oldGames;
	private int oldAmbientOcclusion;
	
	public Xray() {
		super("Xray", Keyboard.KEY_X, me.sempre234.ocipe.module.Category.RENDER); 
		Xray.enabled = false;
	}
	
	@Override
	public void onEnable() {
		Xray.enabled = true;
		this.oldGames = mc.gameSettings.gammaSetting;
		this.oldAmbientOcclusion = mc.gameSettings.ambientOcclusion;
		mc.gameSettings.gammaSetting = 10.0f;
		mc.gameSettings.ambientOcclusion = 0;
		mc.renderGlobal.loadRenderers();
		}
	
	@Override
	public void onDisable() {
		Xray.enabled = false;
		mc.gameSettings.gammaSetting = this.oldGames;
		mc.gameSettings.ambientOcclusion = this.oldAmbientOcclusion;
		mc.renderGlobal.loadRenderers();
	}
	
}
