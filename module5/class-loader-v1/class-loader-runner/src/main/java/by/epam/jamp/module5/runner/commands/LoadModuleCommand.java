package by.epam.jamp.module5.runner.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.ModuleLoader;

public class LoadModuleCommand implements MenuCommand {

	private static final Logger LOG = Logger.getLogger(LoadModuleCommand.class);

	private final ModuleLoader moduleLoader;

	public LoadModuleCommand(ModuleLoader moduleLoader) {
		this.moduleLoader = moduleLoader;
	}

	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LOG.debug("Enter module name: ");
		String moduleName = br.readLine();
		LOG.debug("Enter jar path: ");
		String jar = br.readLine();

		moduleLoader.loadModule(moduleName, jar);
	}

}
