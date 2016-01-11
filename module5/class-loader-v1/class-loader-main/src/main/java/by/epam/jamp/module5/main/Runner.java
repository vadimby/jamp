package by.epam.jamp.module5.main;

import org.apache.log4j.Logger;

public class Runner {

	private static final Logger LOG = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws Exception {

		ModuleLoader loader = new ModuleLoaderImpl();
		loader.loadModule("Module1", "D:\\00\\class-loader-module1-1.0.0-SNAPSHOT.jar");
		loader.loadModule("Module1", "D:\\00\\class-loader-module1-1.0.0-SNAPSHOT.jar");
		loader.loadModule("Module2", "D:\\00\\class-loader-module2-1.0.0-SNAPSHOT.jar");
		loader.loadModule("Module3", "D:\\00\\class-loader-module3-1.0.0-SNAPSHOT.jar");
		loader.loadModule("Module2", "D:\\00\\class-loader-module2-1.0.0-SNAPSHOT.jar");
		loader.loadModule("Module1", "D:\\00\\class-loader-module1-1.0.0-SNAPSHOT.jar");

		for (Integer index : loader.getLoadedModules().keySet()) {
			LOG.debug(index + "). " + loader.getLoadedModules().get(index).getName() + ": "
					+ loader.getLoadedModules().get(index).getModule().getInfo());
		}
	}

}
