package by.epam.jamp.module5.runner.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.ModuleLoader;

public class LoadModuleCommand implements MenuCommand {

	private static final Logger LOG = Logger.getLogger(LoadModuleCommand.class);

	private final ModuleLoader moduleLoader;

	public LoadModuleCommand(ModuleLoader moduleLoader) {
		this.moduleLoader = moduleLoader;
	}

	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LOG.debug("Enter module name: ");
		String moduleName = br.readLine();
		LOG.debug("Enter jar path: ");
		String jar = br.readLine();

		try {
			moduleLoader.loadModule(moduleName, jar);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
