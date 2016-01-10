package by.epam.jamp.module5.runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import by.epam.jamp.module5.runner.commands.LoadModuleCommand;
import by.epam.jamp.module5.runner.commands.MenuCommand;
import by.epam.jamp.module5.runner.commands.ShowModulesCommand;

public class Runner {

	public static void main(String[] args) throws IOException {

		new MainMenu(getLabels(), getCommands()).show();

	}

	private static Map<Integer, String> getLabels() {
		Map<Integer, String> labels = new HashMap<Integer, String>();
		labels.put(1, "Modules");
		labels.put(2, "Load");
		return labels;
	}

	private static Map<Integer, MenuCommand> getCommands() {
		Map<Integer, MenuCommand> commands = new HashMap<Integer, MenuCommand>();
		commands.put(1, new ShowModulesCommand());
		commands.put(2, new LoadModuleCommand());
		return commands;
	}

}
