package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class EnvironmentStateType {

	private final StatefullDuck duck;

	public EnvironmentStateType(StatefullDuck duck) {
		this.duck = duck;
	}

	public void setState(EnvironmentState newState) {
		if (!duck.getCurrentState().getEnvironmentState().equals(newState)) {
			duck.getCurrentState().setEnvironmentState(newState);
			duck.getCurrentState().getEnvironmentState().stateEnter(duck);
		}
	}

	public void toAir() {
		setState(EnvironmentState.AIR);
	}

	public void toGround() {
		setState(EnvironmentState.GROUND);
	}

	public void toWater() {
		setState(EnvironmentState.WATER);
	}
}
