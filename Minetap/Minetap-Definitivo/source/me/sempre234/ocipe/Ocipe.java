package me.sempre234.ocipe;

import org.lwjgl.opengl.Display;

import me.sempre234.ocipe.module.*;


public class Ocipe {
	
	public static String name = "Minetap", version = "1.2", creator = "Freike";
	
	public static ModuleManager moduleManager;
	
	public static void startClient() {
		moduleManager = new ModuleManager();
		
		
		Display.setTitle(name + " " + version + " by " + creator);
	}

}
