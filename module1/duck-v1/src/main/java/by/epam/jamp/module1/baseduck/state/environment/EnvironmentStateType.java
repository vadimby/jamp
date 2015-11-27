package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.Duck;

public class EnvironmentStateType {

	private EnvironmentState state;
	private final Duck duck;

	public EnvironmentStateType(Duck duck) {
		this.duck = duck;
		this.state = EnvironmentState.GROUND;
	}

	private void setState(EnvironmentState newState) {
		if (!this.state.equals(newState)) {
			this.state.stateExit(this);
			this.state = newState;
			this.state.stateEnter(this);
		}
	}

	public Duck getDuck() {
		return duck;
	}

	public void toAir() {
		setState(EnvironmentState.AIR);
	}

	public void toWater() {
		setState(EnvironmentState.WATER);
	}

	public void toEarth() {
		setState(EnvironmentState.GROUND);
	}
}
