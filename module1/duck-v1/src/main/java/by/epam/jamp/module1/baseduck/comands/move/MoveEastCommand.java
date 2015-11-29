package by.epam.jamp.module1.baseduck.comands.move;

import by.epam.jamp.module1.baseduck.comands.Command;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class MoveEastCommand implements Command {

	private StatefullDuck duck;

	public MoveEastCommand(StatefullDuck duck) {
		this.duck = duck;
	}

	public void execute() {
		duck.moveEast();
	}

}
