package me.sempre234.ocipe.module;

import java.util.ArrayList;

import me.sempre234.ocipe.module.movement.*;
import me.sempre234.ocipe.module.render.Xray;

public class ModuleManager {
	
	private static ArrayList<Module> mods;
	
	public ModuleManager(){
		mods = new ArrayList<Module>();
		//COMBAT
		
		//MOVEMENT
		newMod(new AutoSprint());
		newMod(new Flight());
		
		//PLAYER
		
		//RANDER
		newMod(new Xray());
		
		//MISC
	}
	
	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for (Module m : mods) {
			m.onRender();
		}
	}
	public static void onKey(int x) {
		for (Module m : mods) {
			if(m.getKey() == x) {
				m.toggle();
			}
		}
	}


}
