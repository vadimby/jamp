package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.DuckBehaviours;

public class ChargeStateType {

	private ChargeState state;
	private final Duck duck;

	public ChargeStateType(Duck duck, DuckBehaviours fullBehaviour, DuckBehaviours emptyBehavior) {
		this.duck = duck;
		this.state = ChargeState.FULL;
	}

	public void setState(ChargeState newState) {
		state.stateExit(this);
		this.state = newState;
		state.stateEnter(this);
	}

	public Duck getDuck() {
		return duck;
	}

}
