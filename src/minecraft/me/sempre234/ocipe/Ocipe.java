package me.sempre234.ocipe;

import org.lwjgl.opengl.Display;

import me.sempre234.ocipe.module.*;


public class Ocipe {
	
	public static String name = "Ocipe", version = "1.5.2b1",  creator = "Freike";
	
	public static ModuleManager moduleManager;
	
	public static void startClient() {
		moduleManager = new ModuleManager();
		
		
		Display.setTitle(name + " " + version + "by" + creator);
	}

}
