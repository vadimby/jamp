package by.epam.jamp.module5.main;

import java.util.Map;

import by.epam.jamp.module5.main.command.Command;

public class ConsoleMenu {

	private final Map<String, Command> points;

	public ConsoleMenu(Map<String, Command> points) {
		this.points = points;
	}

	public Map<String, Command> getPoints() {
		return points;
	}
	
	

}
