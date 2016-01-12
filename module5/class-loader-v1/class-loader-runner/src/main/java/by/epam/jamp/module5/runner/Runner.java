package by.epam.jamp.module5.runner;

import java.util.HashMap;
import java.util.Map;

import by.epam.jamp.module5.main.ModuleLoader;
import by.epam.jamp.module5.main.ModuleLoaderImpl;
import by.epam.jamp.module5.runner.commands.LoadModuleCommand;
import by.epam.jamp.module5.runner.commands.MenuCommand;
import by.epam.jamp.module5.runner.commands.ShowModulesCommand;

public class Runner {

	public static void main(String[] args) throws Exception {

		ModuleLoader moduleLoader = new ModuleLoaderImpl();
		new MainMenu(getLabels(), getCommands(moduleLoader)).show();

	}

	private static Map<Integer, String> getLabels() {
		Map<Integer, String> labels = new HashMap<Integer, String>();
		labels.put(1, "Modules");
		labels.put(2, "Load");
		return labels;
	}

	private static Map<Integer, MenuCommand> getCommands(ModuleLoader moduleLoader) {
		Map<Integer, MenuCommand> commands = new HashMap<Integer, MenuCommand>();
		commands.put(1, new ShowModulesCommand(moduleLoader));
		commands.put(2, new LoadModuleCommand(moduleLoader));
		return commands;
	}

}
