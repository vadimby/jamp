package by.epam.jamp.module5.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.runner.commands.MenuCommand;

public class MainMenu {

	private static final Logger LOG = Logger.getLogger(Runner.class);

	private Map<Integer, String> labels;
	private Map<Integer, MenuCommand> commands;

	public MainMenu(Map<Integer, String> labels, Map<Integer, MenuCommand> commands) {
		this.labels = labels;
		this.commands = commands;
	}

	public void show() throws IOException {

		while (true) {
			showMenu();

			readInput();
		}

	}

	private void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LOG.debug("Enter String");
		String s = br.readLine();

		MenuCommand menuCommand = commands.get(Integer.parseInt(s));

		if (menuCommand == null) {
			LOG.debug("Wrong input!!! Try again...");
			return;
		}

		menuCommand.run();
	}

	private void showMenu() {
		LOG.debug("==================================");
		for (Integer key : labels.keySet()) {
			LOG.debug(key + "). " + labels.get(key));
		}
	}
}
