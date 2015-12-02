package by.epam.jamp.module1.baseduck.comands.state.action;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.comands.Command;

public class VoiceCommand implements Command {

	private Duck duck;

	public VoiceCommand(Duck duck) {
		this.duck = duck;
	}

	public void execute() {
		duck.quack();
	}

}
