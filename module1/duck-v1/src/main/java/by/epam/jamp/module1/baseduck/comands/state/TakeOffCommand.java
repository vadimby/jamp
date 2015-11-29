package by.epam.jamp.module1.baseduck.comands.state;

import by.epam.jamp.module1.baseduck.comands.Command;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class TakeOffCommand implements Command {

	private StatefullDuck duck;

	public TakeOffCommand(StatefullDuck duck) {
		this.duck = duck;
	}

	public void execute() {
		duck.fly();
	}

}
