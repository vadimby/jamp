package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.DuckBehaviours;

public class EnvironmentStateType {

	private EnvironmentState state;
	private final DuckBehaviours groundBehaviours;
	private final DuckBehaviours waterBehaviours;
	private final DuckBehaviours airBehaviours;
	private final Duck duck;

	public EnvironmentStateType(Duck duck, DuckBehaviours groundBehaviours, DuckBehaviours waterBehaviours,
			DuckBehaviours airBehaviours) {
		this.duck = duck;
		this.groundBehaviours = groundBehaviours;
		this.waterBehaviours = waterBehaviours;
		this.airBehaviours = airBehaviours;
		this.state = EnvironmentState.GROUND;
	}

	private void setState(EnvironmentState newState) {
		if (!this.state.equals(newState)) {
			this.state.stateExit(this);
			this.state = newState;
			this.state.stateEnter(this);
		}
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

	public EnvironmentState getState() {
		return state;
	}

	public DuckBehaviours getGroundBehaviours() {
		return groundBehaviours;
	}

	public DuckBehaviours getWaterBehaviours() {
		return waterBehaviours;
	}

	public DuckBehaviours getAirBehaviours() {
		return airBehaviours;
	}

	public Duck getDuck() {
		return duck;
	}

	//
}
