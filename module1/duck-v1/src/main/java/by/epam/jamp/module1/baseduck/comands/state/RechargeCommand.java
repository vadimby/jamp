package by.epam.jamp.module1.baseduck.comands.state;

import by.epam.jamp.module1.baseduck.comands.Command;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class RechargeCommand implements Command {

	private StatefullDuck duck;

	public RechargeCommand(StatefullDuck duck) {
		this.duck = duck;
	}

	public void execute() {
		duck.recharge();
	}

}
