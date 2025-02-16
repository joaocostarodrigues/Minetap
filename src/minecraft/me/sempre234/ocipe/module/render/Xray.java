package me.sempre234.ocipe.module.render;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.lwjgl.input.Keyboard;

import me.sempre234.ocipe.module.Module;
import net.minecraft.src.Block;

public class Xray extends Module{
	
	public static Boolean enabled;
	private float oldGames;
	public ArrayList<Block> xrayBlocks = new ArrayList<Block>();
	
	public Xray() {
		super("Xray", Keyboard.KEY_X, me.sempre234.ocipe.module.Category.RENDER); 
		Xray.enabled = false;
	}
	
	@Override
	public void onEnable() {
		Xray.enabled = true;
		this.oldGames = mc.gameSettings.gammaSetting;
		mc.gameSettings.gammaSetting = 10.0f;
		mc.gameSettings.ambientOcclusion = 0;
		mc.renderGlobal.loadRenderers();
		}
	
	@Override
	public void onDisable() {
		Xray.enabled = false;
		mc.gameSettings.gammaSetting = this.oldGames;
		mc.gameSettings.ambientOcclusion = 1;
		mc.renderGlobal.loadRenderers();
	}
	
	public boolean shouldXrayBlock(Block blockid) {
		if(this.xrayBlocks.contains(blockid)) {
			return true;
		}
		return false;
	}

}
