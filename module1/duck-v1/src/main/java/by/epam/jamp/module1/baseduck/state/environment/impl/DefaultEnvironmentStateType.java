package by.epam.jamp.module1.baseduck.state.environment.impl;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentState;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public class DefaultEnvironmentStateType implements EnvironmentStateType {

	public void setState(EnvironmentState newState, StatefullDuck duck) {
		if (!duck.getCurrentState().getEnvironmentState().equals(newState)) {
			duck.getCurrentState().setEnvironmentState(newState);
			duck.getCurrentState().getEnvironmentState().stateEnter(duck);
		}
	}

	public void toAir(StatefullDuck duck) {
		setState(EnvironmentState.AIR, duck);
	}

	public void toGround(StatefullDuck duck) {
		setState(EnvironmentState.GROUND, duck);
	}

	public void toWater(StatefullDuck duck) {
		setState(EnvironmentState.WATER, duck);
	}
}
