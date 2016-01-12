package by.epam.jamp.module5.main;

import java.util.HashMap;
import java.util.Map;

public class ModuleLoaderImpl implements ModuleLoader {

	private int index = 1;
	private final Map<Integer, Module> loadedModules = new HashMap<Integer, Module>();

	@SuppressWarnings("unchecked")
	public void loadModule(String name, String path) throws Exception {
		CustomJarClassLoader jarClassLoader = new CustomJarClassLoader(path);
		Class<IModule> loadClass = (Class<IModule>) jarClassLoader.loadMainClass();
		if (loadClass != null) {
			Module module = new Module(index++, name, loadClass.newInstance());
			getLoadedModules().put(module.getId(), module);
		}
	}

	public Map<Integer, Module> getLoadedModules() {
		return loadedModules;
	}

}
