package me.sempre234.ocipe.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import me.sempre234.ocipe.module.movement.AutoSprint;
import me.sempre234.ocipe.module.movement.Flight;
import me.sempre234.ocipe.module.player.FallDamege;
import me.sempre234.ocipe.module.render.Xray;

public class ModuleManager {
	
	private static ArrayList<Module> mods;
	private static final ArrayList<Long> clickTimes = new ArrayList<Long>();
	private static boolean clientEnabled = true;
	private static boolean cpsEnabled = true;
	private static final File configFile = new File("minetap.properties");
	
	public ModuleManager(){
		mods = new ArrayList<Module>();
		newMod(new AutoSprint());
		newMod(new Flight());
		newMod(new Xray());
		newMod(new FallDamege());
		loadConfig();
	}
	
	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}

	public static boolean isClientEnabled() {
		return clientEnabled;
	}

	public static void setClientEnabled(boolean enabled) {
		clientEnabled = enabled;
		if (!enabled) {
			for (Module module : mods) {
				if (module.isToggled()) {
					module.toggle();
				}
			}
		}
		saveConfig();
	}

	public static void toggleClient() {
		setClientEnabled(!clientEnabled);
	}

	public static boolean isCpsEnabled() {
		return cpsEnabled;
	}

	public static void toggleCps() {
		cpsEnabled = !cpsEnabled;
		clickTimes.clear();
		saveConfig();
	}

	public static void recordClick() {
		if (clientEnabled && cpsEnabled) {
			clickTimes.add(Long.valueOf(System.currentTimeMillis()));
			removeExpiredClicks();
		}
	}

	public static int getCps() {
		removeExpiredClicks();
		return clickTimes.size();
	}

	public static void setModuleKey(Module module, int key) {
		module.setKey(key);
		saveConfig();
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onKey(int x) {
		if (!clientEnabled) {
			return;
		}
		for (Module m : mods) {
			if(m.getKey() == x) {
				m.toggle();
			}
		}
	}

	private static void loadConfig() {
		if (!configFile.isFile()) {
			return;
		}

		Properties properties = new Properties();
		FileInputStream input = null;

		try {
			input = new FileInputStream(configFile);
			properties.load(input);
			clientEnabled = Boolean.parseBoolean(properties.getProperty("clientEnabled", "true"));
			cpsEnabled = Boolean.parseBoolean(properties.getProperty("cpsEnabled", "true"));

			for (Module module : mods) {
				String value = properties.getProperty("key." + module.getName());
				if (value != null) {
					module.setKey(Integer.parseInt(value));
				}
			}
		} catch (Exception exception) {
			clientEnabled = true;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception exception) {
				}
			}
		}
	}

	private static void saveConfig() {
		Properties properties = new Properties();
		properties.setProperty("clientEnabled", Boolean.toString(clientEnabled));
		properties.setProperty("cpsEnabled", Boolean.toString(cpsEnabled));

		for (Module module : mods) {
			properties.setProperty("key." + module.getName(), Integer.toString(module.getKey()));
		}

		FileOutputStream output = null;

		try {
			output = new FileOutputStream(configFile);
			properties.store(output, "Minetap settings");
		} catch (Exception exception) {
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (Exception exception) {
				}
			}
		}
	}

	private static void removeExpiredClicks() {
		long limit = System.currentTimeMillis() - 1000L;
		while (!clickTimes.isEmpty() && clickTimes.get(0).longValue() < limit) {
			clickTimes.remove(0);
		}
	}


}
