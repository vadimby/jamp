package by.epam.jamp.module5.main;

import java.util.HashMap;
import java.util.Map;

public class ModuleLoader {

	private int index = 1;
	private final Map<Integer, Module> loadedModules = new HashMap<Integer, Module>();

	public void loadModule(String name, String path)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		CustomJarClassLoader jarClassLoader = new CustomJarClassLoader(path);
		Class<IModule> loadClass = (Class<IModule>) jarClassLoader.loadClass();
		Module module = new Module(index++, name, loadClass.newInstance());
		getLoadedModules().put(module.getId(), module);
	}

	public Map<Integer, Module> getLoadedModules() {
		return loadedModules;
	}

}
