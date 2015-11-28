package by.epam.jamp.module1.baseduck.state.environment;

abstract class EnvironmentState {
	static EnvironmentState initialState;
	static final EnvironmentState GROUND = new EnvironmentStateGround();
	static final EnvironmentState WATER = new EnvironmentStateWater();
	static final EnvironmentState AIR = new EnvironmentStateAir();

	protected EnvironmentState() {
		if (initialState == null) {
			initialState = this;
		}
	}

	abstract void stateExit(EnvironmentStateType owner);

	abstract void stateEnter(EnvironmentStateType owner);

}
