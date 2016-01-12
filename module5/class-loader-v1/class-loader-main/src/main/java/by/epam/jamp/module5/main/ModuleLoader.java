package by.epam.jamp.module5.main;

import java.util.Map;

public interface ModuleLoader {

	void loadModule(String name, String path) throws Exception;

	Map<Integer, Module> getLoadedModules();

}
