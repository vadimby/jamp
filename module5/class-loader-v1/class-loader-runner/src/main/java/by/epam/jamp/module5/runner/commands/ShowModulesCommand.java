package by.epam.jamp.module5.runner.commands;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.ModuleLoader;

public class ShowModulesCommand implements MenuCommand {

	private static final Logger LOG = Logger.getLogger(ShowModulesCommand.class);

	private final ModuleLoader moduleLoader;

	public ShowModulesCommand(ModuleLoader moduleLoader) {
		this.moduleLoader = moduleLoader;
	}

	public void run() {
		LOG.debug("List of the loaded modules: ");
		for (Integer index : moduleLoader.getLoadedModules().keySet()) {
			LOG.debug(index + "). " + moduleLoader.getLoadedModules().get(index).getName() + ": "
					+ moduleLoader.getLoadedModules().get(index).getModule().getInfo());
		}

	}

}
